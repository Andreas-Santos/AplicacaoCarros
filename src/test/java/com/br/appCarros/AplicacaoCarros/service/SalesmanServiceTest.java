package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.exception.SalesmanException;
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

import java.util.Optional;

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

    @Test
    void shouldDeleteSalesmanWhenIdExists() {
        Long id = 1L;
        Salesman salesman = new Salesman();

        given(salesmanRepository.findById(id))
                .willReturn(Optional.of(salesman));

        salesmanService.deleteSalesman(id);

        then(salesmanRepository).should().deleteById(id);
    }

    @Test
    void shouldThrowExceptionWhenSalesmanDoesNotExistOnDelete() {
        Long id = 1L;

        given(salesmanRepository.findById(id))
                .willReturn(Optional.empty());

        SalesmanException exception = Assertions.assertThrows(
                SalesmanException.class, () -> salesmanService.deleteSalesman(id)
        );

        Assertions.assertEquals(
                "Não existe vendedor com esse id!",
                exception.getMessage()
        );

        then(salesmanRepository).should(never()).deleteById(any());
    }

    @Test
    void shouldThrowExceptionWhenSalesmanDoesNotExistOnUpdate() {
        Long id = 1L;

        SalesmanRequest salesmanRequest = mock(SalesmanRequest.class);

        given(salesmanRepository.findById(id))
                .willReturn(Optional.empty());

        SalesmanException exception = Assertions.assertThrows(
                SalesmanException.class, () -> salesmanService.updateSalesman(id, salesmanRequest)
        );

        Assertions.assertEquals(
                "Não existe vendedor com esse id!",
                exception.getMessage()
        );
    }

    @Test
    void shouldUpdateSalesmanWhenIdExists() {
        Long id = 1L;

        Salesman salesman = mock(Salesman.class);

        SalesmanRequest salesmanRequest = mock(SalesmanRequest.class);

        given(salesmanRepository.findById(id))
                .willReturn(Optional.of(salesman));

        salesmanService.updateSalesman(id, salesmanRequest);

        then(salesman).should().updateSalesman(salesmanRequest);
    }
}