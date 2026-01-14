package com.br.appCarros.AplicacaoCarros.models;

import com.br.appCarros.AplicacaoCarros.models.enums.DealCategory;
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
    private double comission;

    @Column(name = "data")
    private LocalDate dealDate;

}
