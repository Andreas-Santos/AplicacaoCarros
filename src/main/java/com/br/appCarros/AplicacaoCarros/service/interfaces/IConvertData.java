package com.br.appCarros.AplicacaoCarros.service.interfaces;

import java.util.List;

public interface IConvertData {
    <T> T getData(String json, Class<T> classType);
    <T> List<T> getList(String json, Class<T> classType);
}
