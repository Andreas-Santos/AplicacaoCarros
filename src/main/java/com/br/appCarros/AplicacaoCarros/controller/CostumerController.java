package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.CostumerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Transactional
    public void createCostumer(@RequestBody @Valid CreateCostumerRequest costumerRequest) {
        costumerService.createCostumer(costumerRequest);
    }
}
