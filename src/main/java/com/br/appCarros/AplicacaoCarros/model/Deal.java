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

    @OneToOne(mappedBy = "deal")
    private Vehicle vehicle;

    @ManyToMany
    private List<Salesman> salesmanList;

    @ManyToOne
    private Costumer costumer;

    @Column(name = "comissao")
    private Double comission;

    @Column(name = "data")
    private LocalDate dealDate;

    public Deal() {}

    public Deal(Vehicle vehicle, List<Salesman> salesmanList, Costumer costumer, Double comission, LocalDate dealDate) {
        this.vehicle = vehicle;
        this.salesmanList = salesmanList;
        this.costumer = costumer;
        this.comission = comission;
        this.dealDate = dealDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(List<Salesman> salesmanList) {
        this.salesmanList = salesmanList;
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
