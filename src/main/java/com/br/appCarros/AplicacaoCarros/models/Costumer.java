package com.br.appCarros.AplicacaoCarros.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clientes")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf;

    private String email;

    @Column(name = "numeroTelefone")
    private String phoneNumber;

    @OneToMany(mappedBy = "costumer")
    private List<Deal> deals;

    public Costumer() {}

    public Costumer(String name, String cpf, String email, String phoneNumber, List<Deal> deals) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.deals = deals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }
}
