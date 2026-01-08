package com.br.appCarros.AplicacaoCarros.models;

import java.time.LocalDate;
import java.util.List;

public class Salesman {
    private String name;
    private LocalDate initialDate;
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
