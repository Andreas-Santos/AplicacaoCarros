package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/negocios")
public class DealController {
    @Autowired
    DealService dealService;

    @GetMapping
    public List<DealDTO> getDeals() {
        return dealService.getDeals();
    }

    @GetMapping("/{id}")
    public DealDTO getDealById(@PathVariable Long id) {
        return dealService.getDealById(id);
    }
}
