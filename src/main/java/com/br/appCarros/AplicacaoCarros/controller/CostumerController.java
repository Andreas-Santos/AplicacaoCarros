package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.request.CreateCostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.CostumerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createCostumer(@RequestBody @Valid CreateCostumerRequest costumerRequest) {
        costumerService.createCostumer(costumerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteCostumer(@PathVariable Long id) {
        costumerService.deleteCostumer(id);

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }
}
