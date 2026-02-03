package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.mapper.SalesmanMapper;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.repository.SalesmanRepository;
import com.br.appCarros.AplicacaoCarros.request.SalesmanRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class SalesmanServiceTest {
    @InjectMocks
    SalesmanService salesmanService;

    @Mock
    Salesman salesman;

    @Mock
    SalesmanRequest salesmanRequest;

    @Mock
    SalesmanMapper salesmanMapper;

    @Mock
    SalesmanRepository salesmanRepository;

    @Captor
    ArgumentCaptor<Salesman> salesmanCaptor;


    @Test
    void shouldCreateSalesmanWhenRequestIsValid() {
        this.salesmanRequest = new SalesmanRequest("José");
        this.salesman = new Salesman("José");

        given(salesmanMapper.toEntity(salesmanRequest))
                .willReturn(salesman);

        salesmanService.createSalesman(salesmanRequest);
        then(salesmanRepository).should().save(salesmanCaptor.capture());

        Assertions.assertEquals(salesmanCaptor.getValue().getName(), salesman.getName());
    }
}