package com.br.appCarros.AplicacaoCarros.model;

import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;
import com.br.appCarros.AplicacaoCarros.service.Utils.PhoneUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String cpf;

    private String email;

    @Column(name = "numeroTelefone")
    private String phoneNumber;

    public Costumer() {}

    public Costumer(String name, String cpf, String email, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public void cleanCpf() {
        this.cpf = CpfUtils.cleanCpf(cpf);
    }

    public void cleanPhone() {
        this.phoneNumber = PhoneUtils.cleanPhone(phoneNumber);
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nome: " + name + "\n" +
                "CPF: " + cpf + "\n" +
                "Email: " + email + "\n" +
                "Telefone: " + phoneNumber + "\n";
    }
}
