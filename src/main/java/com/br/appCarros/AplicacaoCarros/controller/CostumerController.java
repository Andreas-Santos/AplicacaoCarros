package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CostumerController {
    @Autowired
    CostumerService costumerService;

    @GetMapping
    public List<CostumerDTO> getCostumers() {
        return costumerService.getCostumers();
    }

    @GetMapping(("/{id}"))
    public CostumerDTO getCostumerById(@PathVariable Long id) {
        return costumerService.getCostumerById(id);
    }
}
