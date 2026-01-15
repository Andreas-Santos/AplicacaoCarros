package com.br.appCarros.AplicacaoCarros.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vendedores")
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate initialDate;

    @OneToMany(mappedBy = "salesman", fetch = FetchType.EAGER)
    private List<Deal> deals;

    public Salesman() {}

    public Salesman(String name, List<Deal> deals) {
        this.name = name;
        this.initialDate = LocalDate.now();
        this.deals = deals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
        deal.setSalesman(this);
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Data inicial: " + initialDate + "\n";
    }
}
