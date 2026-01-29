package com.br.appCarros.AplicacaoCarros.model;

import com.br.appCarros.AplicacaoCarros.request.VehicleRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "veículos")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_id")
    private Long brandId;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo_id")
    private Long modelId;

    @Column(name = "modelo")
    private String model;

    @Column(name = "ano_id")
    private String yearId;

    @Column(name = "ano_modelo")
    private String modelYear;

    @Column(name = "combustivel")
    private String fuel;

    @Column(name = "preco")
    private String price;

    @Column(name = "referencia_mes")
    private String referenceMonth;

    public Vehicle() {}

    public Vehicle(Long brandId, String brand, Long modelId, String model, String yearId, String modelYear,
                    String fuel, String price, String referenceMonth) {
        this.brandId = brandId;
        this.brand = brand;
        this.modelId = modelId;
        this.model = model;
        this.yearId = yearId;
        this.modelYear = modelYear;
        this.fuel = fuel;
        this.price = price;
        this.referenceMonth = referenceMonth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceMonth() {
        return referenceMonth;
    }

    public void setReferenceMonth(String referenceMonth) {
        this.referenceMonth = referenceMonth;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void updateVehicle(VehicleRequest vehicleRequest) {
        this.brandId = vehicleRequest.brandId();
        this.brand = vehicleRequest.brand();
        this.modelId = vehicleRequest.modelId();
        this.model = vehicleRequest.model();
        this.yearId = vehicleRequest.yearId();
        this.modelYear = vehicleRequest.modelYear();
        this.fuel = vehicleRequest.fuel();
        this.price = vehicleRequest.price();
        this.referenceMonth = vehicleRequest.referenceMonth();
    }

    @Override
    public String toString() {
        return
                "Id: " + this.id + "\n" +
                "Marca: " + this.brand + "\n" +
                "Modelo: " + this.model + "\n" +
                "Ano: " + this.modelYear + "\n" +
                "Combustível: " + this.fuel + "\n" +
                "Preço: " + this.price + "\n";
    }
}
