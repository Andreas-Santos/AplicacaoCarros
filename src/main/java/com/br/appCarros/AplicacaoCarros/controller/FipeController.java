package com.br.appCarros.AplicacaoCarros.controller;

import com.br.appCarros.AplicacaoCarros.model.record.BrandData;
import com.br.appCarros.AplicacaoCarros.model.record.ModelData;
import com.br.appCarros.AplicacaoCarros.model.record.YearData;
import com.br.appCarros.AplicacaoCarros.service.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class FipeController {
    @Autowired
    FipeService fipeService;

    @GetMapping
    public List<BrandData> getBrands() {
        return fipeService.getBrands();
    }

    @GetMapping("/{brandId}")
    public List<YearData> getYears(@PathVariable int brandId) {
        return fipeService.getYears(brandId);
    }

    @GetMapping("/{brandId}/{yearId}")
    public List<ModelData> getModels(@PathVariable int brandId, @PathVariable String yearId) {
        return fipeService.getModels(brandId, yearId);
    }
}
