package com.br.appCarros.AplicacaoCarros.models;

import com.br.appCarros.AplicacaoCarros.models.enums.DealCategory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

public class Deal {
    private List<Vehicle> purchasedVehicles;
    private List<Vehicle> selledVehicles;
    private DealCategory dealCategory;
    private List<Salesman> salesmanList;
    private Costumer costumer;
    private double comission;
    private LocalDate dealDate;

}
