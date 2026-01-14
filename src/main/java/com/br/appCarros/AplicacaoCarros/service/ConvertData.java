package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.service.interfaces.IConvertData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConvertData implements IConvertData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classType) {
        try {
            return mapper.readValue(json, classType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> getList(String json, Class<T> classType) {
        CollectionType list = mapper.getTypeFactory()
                .constructCollectionType(List.class, classType);

        try {
            return mapper.readValue(json, list);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
