package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping
//    public createSalesman(@RequestBody SalesmanRequest salesmanRequest) {
//
//    }
}
