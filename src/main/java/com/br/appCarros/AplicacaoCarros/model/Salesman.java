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

    @Column(name = "nome")
    private String name;

    @Column(name = "data_inicial")
    private LocalDate initialDate;

    @ManyToMany(mappedBy = "salesmanList")
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
}
