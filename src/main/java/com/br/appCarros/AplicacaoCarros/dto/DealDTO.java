package com.br.appCarros.AplicacaoCarros.dto;

import com.br.appCarros.AplicacaoCarros.model.Deal;

import java.time.LocalDate;

public record DealDTO(
        Long id,
        VehicleDTO vehicle,
        SalesmanDTO salesman,
        CostumerDTO costumer,
        Double comission,
        LocalDate dealDate
){

    public DealDTO(Deal deal) {
        this(deal.getId(), new VehicleDTO(deal.getVehicle()), new SalesmanDTO(deal.getSalesman()),
                new CostumerDTO(deal.getCostumer()), deal.getComission(), deal.getDealDate());
    }
}
