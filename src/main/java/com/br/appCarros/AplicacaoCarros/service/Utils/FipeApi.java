package com.br.appCarros.AplicacaoCarros.service.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FipeApi {
    @Autowired
    ApiConsume apiConsumer;

    public FipeApi() {}

    public String getBrands(String vehicleType) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands";

        return apiConsumer.getApiData(url);
    }

    public String getModelsByProducer(String vehicleType, int brandId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands/" + brandId + "/models";

        return apiConsumer.getApiData(url);
    }

    public String getModelsByProducerAndYear(String vehicleType, int brandId, String yearId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands/" + brandId +
                "/years/" + yearId + "/models";

        return apiConsumer.getApiData(url);
    }

    public String getYearsByModel(String vehicleType, int brandId, int modelId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands/" + brandId +
                "/models/" + modelId + "/years";

        return apiConsumer.getApiData(url);
    }

    public String getYearsByProducer(String vehicleType, int brandId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands/" + brandId + "/years";

        return apiConsumer.getApiData(url);
    }

    public String getInfoFipe(String vehicleType, int brandId, int modelId, String yearId) {
        String url = "https://fipe.parallelum.com.br/api/v2/" + vehicleType + "/brands/" + brandId +
                "/models/" + modelId + "/years/" + yearId;

        return apiConsumer.getApiData(url);
    }
}
