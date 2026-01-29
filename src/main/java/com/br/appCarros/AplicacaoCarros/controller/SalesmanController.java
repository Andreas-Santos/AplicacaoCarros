package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.request.CreateSalesmanRequest;
import com.br.appCarros.AplicacaoCarros.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class SalesmanController {
    @Autowired
    SalesmanService salesmanService;

    @GetMapping
    public List<SalesmanDTO> getSalesman() {
        return salesmanService.getSalesman();
    }

    @GetMapping("/{id}")
    public SalesmanDTO getSalesmanById(@PathVariable Long id) {
        return salesmanService.getSalesmanById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createSalesman(@RequestBody @Valid CreateSalesmanRequest salesmanRequest) {
        salesmanService.createSalesman(salesmanRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Vendedor criado com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteSalesman(@PathVariable Long id) {
        salesmanService.deleteSalesman(id);

        return ResponseEntity.status(HttpStatus.OK).body("Vendedor deletado com sucesso!");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> updateSalesman(@PathVariable Long id, @RequestBody @Valid CreateSalesmanRequest salesmanRequest) {
        salesmanService.updateSalesman(id, salesmanRequest);

        return ResponseEntity.status(HttpStatus.OK).body("Vendedor alterado com sucesso!");
    }
}
