package com.br.appCarros.AplicacaoCarros.application;

import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.model.record.BrandData;
import com.br.appCarros.AplicacaoCarros.model.record.ModelData;
import com.br.appCarros.AplicacaoCarros.model.record.VehicleFipeData;
import com.br.appCarros.AplicacaoCarros.model.record.YearData;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.repository.DealRepository;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.service.ConvertData;
import com.br.appCarros.AplicacaoCarros.service.FipeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private final FipeApi fipeApi = new FipeApi();
    private final ConvertData dataConverter = new ConvertData();
    private final Scanner scan = new Scanner(System.in);
    private final VehicleRepository vehicleRepository;
    private final CostumerRepository costumerRepository;
    private final SalesmanRepository salesmanRepository;
    private final DealRepository dealRepository;

    public Main(VehicleRepository vehicleRepository, CostumerRepository costumerRepository,
                SalesmanRepository salesmanRepository, DealRepository dealRepository) {
        this.vehicleRepository = vehicleRepository;
        this.costumerRepository = costumerRepository;
        this.salesmanRepository = salesmanRepository;
        this.dealRepository = dealRepository;
    }

    public void showMenu() {
        int menuChoose = -1;

        System.out.println("Bem vindo ao Sistemas de veículos!");

        while(menuChoose != 0) {
            System.out.println(
                """
                    Escolha a opção desejada:
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Cadastrar Veículo
                    4 - Listar Veículos
                    5 - Cadastrar Venda
                    7 - Cadastrar Vendedor
                    8 - Listar Vendedores
                    9 - Buscar vendedor
                    0 - Sair
                """);
            menuChoose = scan.nextInt();
            scan.nextLine();

            switch (menuChoose) {
                case 1:
                    registerCostumer();
                    break;
                case 2:
                    getCostumers();
                    break;
                case 3:
                    registerVehicle();
                    break;
                case 4:
                    getVehicles();
                    break;
                case 5:
                    registerDeal();
                    break;
                case 7:
                    registerSalesman();
                    break;
                case 8:
                    getSalesman();
                    break;
                case 9:
                    searchSalesman();
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    break;
                default:
                    System.out.println("O número digitado é inválido!");
                    break;
            }
        }
    }

    private void registerDeal() {
        Vehicle vehicle;
        Salesman salesman;
        Costumer costumer;
        Double comission = 1000.00;

        getVehicles();
        System.out.println("Digite o id do veículo:");
        long vehicleId = scan.nextLong();

        vehicle = vehicleRepository.findByIdEquals(vehicleId);

        if(vehicle == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        getSalesman();
        System.out.println("Digite o id do vendedor:");
        long salesmanId = scan.nextLong();

        salesman = salesmanRepository.findByIdEquals(salesmanId);

        if(salesman == null) {
            System.out.println("Vendedor não encontrado!");
            return;
        }

        getCostumers();
        System.out.println("Digite o id do cliente:");
        long costumerId = scan.nextLong();

        costumer = costumerRepository.findByIdEquals(costumerId);

        if(costumer == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        Deal deal = new Deal(vehicle, salesman, costumer, comission);

        try {
            vehicle.setDeal(deal);
            dealRepository.save(deal);
            vehicleRepository.save(vehicle);
            System.out.println("Venda cadastrada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastar venda - Erro: " + e.getMessage());
        }
    }

    private void getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        vehicles.stream().
                forEach(v -> System.out.println(v));
    }

    private void registerVehicle() {
        var jsonBrands = fipeApi.getBrands("cars");
        var brands = dataConverter.getList(jsonBrands, BrandData.class);

        System.out.println("Digite a marca do veículo:");
        String brandSearch = scan.nextLine();

        Optional<List<BrandData>> optionalBrandData = Optional.of(brands.stream()
                .filter(b -> b.brandName().toUpperCase().contains(brandSearch.toUpperCase()))
                .collect(Collectors.toList()));

        if(optionalBrandData.isEmpty()) {
            System.out.println("Não foi encontrada marcas com o nome digitado!");
            return;
        }

        optionalBrandData.get().forEach(
                b -> System.out.println("Código: " + b.brandCode() + " Marca: " + b.brandName()));
        System.out.println("Digite o código da marca desejado:");
        int brandId = scan.nextInt();
        scan.nextLine();

        Optional<BrandData> brandFiltered = optionalBrandData.get().stream()
                .filter(b -> b.brandCode().equals(brandId))
                .findFirst();

        if(brandFiltered.isEmpty()) {
            System.out.println("Não foi encontrada uma marca com o código digitado!");
            return;
        }

        System.out.println("Qual o ano do veículo?");
        int yearSearch = scan.nextInt();
        scan.nextLine();

        System.out.println(
                """
                    Digite o número do combustível:
                    1 - Gasolina
                    2 - Álcool
                    3 - Diesel
                    4 - Elétrico
                    5 - Flex
                    6 - Híbrido   
                """
        );
        int fuelId = scan.nextInt();
        scan.nextLine();

        var jsonYears = fipeApi.getYearsByProducer("cars", brandId);
        var years = dataConverter.getList(jsonYears, YearData.class);

        String yearId = yearSearch + "-" + fuelId;

        Optional<YearData> yearFiltered = years.stream().
                filter(y -> y.yearCode().equals(yearId))
                .findFirst();

        if(yearFiltered.isEmpty()) {
            System.out.println("Não foi encontrado veículos desse ano/combustível para a marca "
                    + brandFiltered.get().brandName());
            return;
        }

        System.out.println("Digite o modelo do veículo:");
        String modelSearch = scan.nextLine();

        var jsonModels = fipeApi.getModelsByProducerAndYear("cars", brandId, yearId);
        var models = dataConverter.getList(jsonModels, ModelData.class);

        Optional<List<ModelData>> optionalModelData = Optional.of(models.stream()
                .filter(m -> m.modelName().toUpperCase().contains(modelSearch.toUpperCase()))
                .collect(Collectors.toList()));

        if(optionalModelData.isEmpty()) {
            System.out.println("Modelo digitado não foi encontrado!");
            return;
        }

        optionalModelData.get().stream().
            forEach(m -> System.out.println("Código: " + m.modelCode() +
                    " Modelo: " + m.modelName()));
        System.out.println("Digite o código do modelo desejado:");
        int modelId = scan.nextInt();

        Optional<ModelData> modelFiltered = optionalModelData.get().stream().
                filter(m -> m.modelCode().equals(modelId))
                .findFirst();

        if(modelFiltered.isEmpty()) {
            System.out.println("Não foi encontrado um modelo com esse código!");
            return;
        }

        var jsonFipe = fipeApi.getInfoFipe("cars", brandId, modelId, yearId);
        var fipe = dataConverter.getData(jsonFipe, VehicleFipeData.class);

        System.out.println(
                "Marca: " + fipe.brand() +
                "\nModelo: " + fipe.model() +
                "\nAno: " + fipe.modelYear() +
                "\nTipo do Combustível: " + fipe.fuel() +
                "\nPreço fipe: " + fipe.price() +
                "\nMês de referência: " + fipe.referenceMonth()
        );

        Vehicle vehicle = new Vehicle(
                brandId,
                fipe.brand(),
                modelId,
                fipe.model(),
                yearId,
                fipe.modelYear(),
                fipe.fuel(),
                fipe.price(),
                fipe.referenceMonth()
        );

        try {
            vehicleRepository.save(vehicle);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastar veículo - Erro: " + e.getMessage());
        }
    }

    private void searchSalesman() {
        System.out.println("Digite o nome do vendedor que quer buscar");
        String name = scan.nextLine();
        List<Salesman> salesman = new ArrayList<>();

        salesman = salesmanRepository.findByNameContainingIgnoreCase(name);
        System.out.println(salesman);
    }


    private void getCostumers() {
        List<Costumer> costumers = new ArrayList<>();
        costumers = costumerRepository.findAll();

        costumers.stream()
                .forEach(c -> System.out.println(c));
    }

    private void registerCostumer() {
        String name;
        String cpf;
        String email;
        String phoneNumber;

        System.out.println("Digite o nome do cliente:");
        name = scan.nextLine();
        System.out.println("Digite o cpf do cliente:");
        cpf = scan.nextLine();
        System.out.println("Digite o email do cliente:");
        email = scan.nextLine();
        System.out.println("Digite o número do telefone:");
        phoneNumber = scan.nextLine();

        Costumer costumer = new Costumer(name, cpf, email, phoneNumber, null);
        try{
            costumerRepository.save(costumer);
            System.out.println("Cliente cadastrado com sucesso!");
        }catch (Exception e) {
            System.out.println("Erro ao cadastar cliente - Erro: " + e.getMessage());
        }
    }

    private void getSalesman() {
        List<Salesman> salesmanList = new ArrayList<>();
        salesmanList = salesmanRepository.findAll();

        salesmanList.stream()
                .forEach(s -> System.out.println(s));
    }

    private void registerSalesman() {
        String name;

        System.out.println("Digite o nome do vendedor");
        name = scan.nextLine();

        Salesman salesman = new Salesman(name, null);
        try {
            salesmanRepository.save(salesman);
            System.out.println("Vendedor cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar vendedor - Erro: " + e.getMessage());
        }
    }
}
