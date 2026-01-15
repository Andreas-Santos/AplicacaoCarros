package com.br.appCarros.AplicacaoCarros.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "negocios")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "deal", cascade = CascadeType.MERGE)
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Salesman salesman;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Costumer costumer;

    @Column(name = "comissao")
    private Double comission;

    @Column(name = "data")
    private LocalDate dealDate;

    public Deal() {}

    public Deal(Vehicle vehicle, Salesman salesman, Costumer costumer, Double comission) {
        this.comission = comission;
        this.dealDate = LocalDate.now();

        setVehicle(vehicle);
        setSalesman(salesman);
        setCostumer(costumer);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        if (vehicle != null) {
            vehicle.setDeal(this);
        }
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        this.comission = comission;
    }

    public LocalDate getDealDate() {
        return dealDate;
    }

    public void setDealDate(LocalDate dealDate) {
        this.dealDate = dealDate;
    }
}
