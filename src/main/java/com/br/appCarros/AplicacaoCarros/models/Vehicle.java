package com.br.appCarros.AplicacaoCarros.models;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.AbstractAuditable_;

@Entity
@Table(name = "veículos")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_id")
    private Integer brandId;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo_id")
    private Integer modelId;

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

    @OneToOne
    private Deal deal;

    public Vehicle() {}

    public Vehicle(Integer brandId, String brand, Integer modelId, String model, String yearId, String modelYear,
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

    @Override
    public String toString() {
        return "Marca: " + this.brand + "\n" +
                "Modelo: " + this.model + "\n" +
                "Ano: " + this.modelYear + "\n" +
                "Combustível: " + this.fuel + "\n" +
                "Preço: " + this.price + "\n";
    }
}
