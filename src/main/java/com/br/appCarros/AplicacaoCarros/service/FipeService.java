package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.model.record.BrandData;
import com.br.appCarros.AplicacaoCarros.model.record.ModelData;
import com.br.appCarros.AplicacaoCarros.model.record.VehicleFipeData;
import com.br.appCarros.AplicacaoCarros.model.record.YearData;
import com.br.appCarros.AplicacaoCarros.service.API.ConvertData;
import com.br.appCarros.AplicacaoCarros.service.API.FipeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FipeService {
    @Autowired
    FipeApi fipeApi;

    @Autowired
    ConvertData dataConverter;

    public List<BrandData> getBrands() {
        var jsonBrands = fipeApi.getBrands("cars");
        List<BrandData> brands = dataConverter.getList(jsonBrands, BrandData.class);

        return brands;
    }

    public List<YearData> getYears(int brandId) {
        var jsonYears = fipeApi.getYearsByProducer("cars", brandId);
        List<YearData> years = dataConverter.getList(jsonYears, YearData.class);

        return years;
    }

    public List<ModelData> getModels(int brandId, String yearId) {
        var jsonModels = fipeApi.getModelsByProducerAndYear("cars", brandId, yearId);
        List<ModelData> models = dataConverter.getList(jsonModels, ModelData.class);

        return models;
    }

    public VehicleFipeData getInfoFipe(Integer brandId, Integer modelId, String yearId) {
        var jsonVehicle = fipeApi.getInfoFipe("cars", brandId, modelId, yearId);
        VehicleFipeData vehicleFipe = dataConverter.getData(jsonVehicle, VehicleFipeData.class);

        return vehicleFipe;
    }
}
