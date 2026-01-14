package com.br.appCarros.AplicacaoCarros.application;

import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.model.record.BrandData;
import com.br.appCarros.AplicacaoCarros.model.record.ModelData;
import com.br.appCarros.AplicacaoCarros.model.record.VehicleFipeData;
import com.br.appCarros.AplicacaoCarros.model.record.YearData;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
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

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private FipeApi fipeApi = new FipeApi();
    private ConvertData dataConverter = new ConvertData();
    private Scanner scan = new Scanner(System.in);
    private VehicleRepository vehicleRepository;
    private CostumerRepository costumerRepository;
    private SalesmanRepository salesmanRepository;

    public Main(VehicleRepository vehicleRepository, CostumerRepository costumerRepository,
                SalesmanRepository salesmanRepository) {
        this.vehicleRepository = vehicleRepository;
        this.costumerRepository = costumerRepository;
        this.salesmanRepository = salesmanRepository;
    }

    public void showMenu() {
        int menuChoose = -1;

        System.out.println("Bem vindo ao Sistemas de veículos!");

        while(menuChoose != 0) {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("7 - Cadastrar Vendedor");
            System.out.println("8 - Listar Vendedores");
            System.out.println("9 - Buscar vendedor");
            System.out.println("0 - Sair");
            menuChoose = scan.nextInt();
            scan.nextLine();

            switch (menuChoose) {
                case 1:
                    registerCostumer();
                    break;
                case 2:
                    getCostumers();
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
            }
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

    public void showMore() {
        var jsonBrands = fipeApi.getBrands("cars");
        var brands = dataConverter.getList(jsonBrands, BrandData.class);

        for(BrandData brand : brands) {
            System.out.println("Código da marca: " + brand.brandCode() + " Marca: " + brand.brandName());
        }
        System.out.println("Digite o código da marca que deseja buscar:");
        var brandSearch = scan.nextInt();
        scan.nextLine();

        Optional<BrandData> brandFiltered= brands.stream()
                .filter(b -> b.brandCode().equals(brandSearch))
                .findFirst();

        brandFiltered.ifPresentOrElse(
                b -> System.out.println(
                        "Código da marca: " + b.brandCode() +
                                " Marca: " + b.brandName()
                ),
                () -> {
                    System.out.println("Marca não encontrada");
                    System.exit(0);
                }
        );

        var jsonYears = fipeApi.getYearsByProducer("cars", brandSearch);
        var years = dataConverter.getList(jsonYears, YearData.class);

        for(YearData year : years) {
            System.out.println("Código do ano: " + year.yearCode() + " Ano: " + year.yearName());
        }

        System.out.println("Digite o código do ano que deseja buscar:");
        var yearSearch = scan.nextLine();

        var jsonModels = fipeApi.getModelsByProducerAndYear("cars", brandSearch, yearSearch);
        var models = dataConverter.getList(jsonModels, ModelData.class);

        for(ModelData model : models) {
            System.out.println("Código do modelo: " + model.modelCode() + " Modelo: " + model.modelName());
        }

        System.out.println("Digite o código do modelo que deseja buscar");
        var modelSearch = scan.nextInt();
        scan.nextLine();

        var jsonFipe = fipeApi.getInfoFipe("cars", brandSearch, modelSearch, yearSearch);
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
                brandSearch,
                fipe.brand(),
                modelSearch,
                fipe.model(),
                yearSearch,
                fipe.modelYear(),
                fipe.fuel(),
                fipe.price(),
                fipe.referenceMonth()
        );

        try {
            vehicleRepository.save(vehicle);
            System.out.println("Veículo cadastrado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Carros salvos no banco:");
        vehicleRepository.findAll().stream()
                .forEach(System.out::println);
    }
}
