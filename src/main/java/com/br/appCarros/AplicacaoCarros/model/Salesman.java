package com.br.appCarros.AplicacaoCarros.model;

import com.br.appCarros.AplicacaoCarros.request.SalesmanRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vendedores")
public class Salesman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_inicial")
    private LocalDate initialDate = LocalDate.now();;

    public Salesman() {}

    public Salesman(String name) {
        this.name = name;
        this.initialDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void updateSalesman(SalesmanRequest salesmanRequest) {
        this.name = salesmanRequest.name();
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nome: " + name + "\n" +
                "Data inicial: " + initialDate + "\n";
    }
}
