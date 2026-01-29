package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.request.DealRequest;
import com.br.appCarros.AplicacaoCarros.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @Transactional
    public ResponseEntity<String> createDeal(@RequestBody DealRequest dealRequest) {
        dealService.createDeal(dealRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Venda criada com sucesso!");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteDeal(@PathVariable Long id) {
        dealService.deleteDeal(id);

        return ResponseEntity.status(HttpStatus.OK).body("Venda deletada com sucesso!");
    }
}
