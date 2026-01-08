package com.br.appCarros.AplicacaoCarros.models;

import com.br.appCarros.AplicacaoCarros.models.enums.VehicleCategory;

import java.time.LocalDate;
import java.util.List;

public class Vehicle {
    private VehicleCategory vehicleCategory;
    private int producerId;
    private String producer;
    private int modelId;
    private String model;
    private int producedYear;
    private int modelYearId;
    private int modelYear;
    private String plate;
    private LocalDate registerDate;
    private double fipeValue;
    private double finalValue;
    private double buyValue;
    private List<Spent> spents;

    public Vehicle(String producer, String model, String plate, int producedYear, int modelYear) {
        this.producer = producer;
        this.model = model;
        this.plate = plate;
        this.registerDate = LocalDate.now();
        this.producedYear = producedYear;
        this.modelYear = modelYear;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProducedYear() {
        return producedYear;
    }

    public void setProducedYear(int producedYear) {
        this.producedYear = producedYear;
    }

    public int getModelYearId() {
        return modelYearId;
    }

    public void setModelYearId(int modelYearId) {
        this.modelYearId = modelYearId;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public double getFipeValue() {
        return fipeValue;
    }

    public void setFipeValue(double fipeValue) {
        this.fipeValue = fipeValue;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }

    public double getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(double buyValue) {
        this.buyValue = buyValue;
    }

    public List<Spent> getSpents() {
        return spents;
    }

    public void setSpents(List<Spent> spents) {
        this.spents = spents;
    }
}
