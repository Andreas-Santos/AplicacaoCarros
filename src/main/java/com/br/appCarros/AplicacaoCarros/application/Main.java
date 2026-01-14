package com.br.appCarros.AplicacaoCarros.application;

import com.br.appCarros.AplicacaoCarros.models.Vehicle;
import com.br.appCarros.AplicacaoCarros.models.records.BrandData;
import com.br.appCarros.AplicacaoCarros.models.records.ModelData;
import com.br.appCarros.AplicacaoCarros.models.records.VehicleFipeData;
import com.br.appCarros.AplicacaoCarros.models.records.YearData;
import com.br.appCarros.AplicacaoCarros.repositorys.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.services.ConvertData;
import com.br.appCarros.AplicacaoCarros.services.FipeApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private FipeApi fipeApi = new FipeApi();
    private ConvertData dataConverter = new ConvertData();
    private Scanner scan = new Scanner(System.in);
    private VehicleRepository vehicleRepository;

    public Main(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void showMenu() {
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
