package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.exception.CostumerException;
import com.br.appCarros.AplicacaoCarros.mapper.CostumerMapper;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.repository.CostumerRepository;
import com.br.appCarros.AplicacaoCarros.request.CostumerRequest;
import com.br.appCarros.AplicacaoCarros.service.Utils.CpfUtils;
import com.br.appCarros.AplicacaoCarros.validation.Costumer.CostumerValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class CostumerServiceTest {
    @InjectMocks
    private CostumerService costumerService;

    @Mock
    private CostumerRepository costumerRepository;

    @Mock
    private CostumerMapper costumerMapper;

    @Mock
    private CostumerValidator validator;

    @Mock
    private CostumerRequest costumerRequest;

    @Mock
    private Costumer costumer;

    @Captor
    private ArgumentCaptor<Costumer> costumerCaptor;

    @BeforeEach
    void setup() {
        costumerService.validators = List.of(validator);
    }

    @Test
    void shouldThrowExceptionWhenRequestIsInvalid() {
        this.costumerRequest = new CostumerRequest(
                "João",
                "111.111.111-11",
                "joao-gmail.com",
                "15997774142"
        );

        willThrow(new CostumerException("Dados inválidos!"))
                .given(validator)
                .validate(costumerRequest);

        CostumerException exception = Assertions.assertThrows(
                CostumerException.class, () -> costumerService.createCostumer(costumerRequest)
        );

        Assertions.assertEquals("Dados inválidos!", exception.getMessage());

        then(costumerMapper).shouldHaveNoInteractions();
        then(costumerRepository).shouldHaveNoInteractions();
    }

    @Test
    void shouldCreateCostumerWhenRequestIsValid() {
        this.costumerRequest = new CostumerRequest(
                "João",
                "792.580.360-69",
                "joao@gmail.com",
                "15997774142"
        );

        Costumer costumer = new Costumer(
                "João",
                "792.580.360-69",
                "joao@gmail.com",
                "15997774142"
        );


        given(costumerMapper.toEntity(costumerRequest))
                .willReturn(costumer);

        costumerService.createCostumer(costumerRequest);

        then(validator).should().validate(costumerRequest);
        then(costumerRepository).should()
                .save(costumerCaptor.capture());

        Costumer createdCostumer = costumerCaptor.getValue();

        Assertions.assertEquals(createdCostumer.getName(), costumerRequest.name());
        Assertions.assertEquals(createdCostumer.getCpf(), CpfUtils.cleanCpf(costumerRequest.cpf()));
        Assertions.assertEquals(createdCostumer.getEmail(), costumerRequest.email());
        Assertions.assertEquals(createdCostumer.getPhoneNumber(), costumerRequest.phoneNumber());
    }

    @Test
    void shouldDeleteCostumerWhenIdExists() {
        Long id = 1L;
        Costumer costumer = new Costumer();

        given(costumerRepository.findById(id))
                .willReturn(Optional.of(costumer));

        costumerService.deleteCostumer(id);

        then(costumerRepository).should().deleteById(id);
    }

    @Test
    void shouldThrowExceptionWhenCostumerDoesNotExistOnDelete() {
        Long id = 1L;

        given(costumerRepository.findById(id))
                .willReturn(Optional.empty());

        CostumerException exception = Assertions.assertThrows(
                CostumerException.class, () -> costumerService.deleteCostumer(id)
        );

        Assertions.assertEquals(
                "Não existe cliente com este id!",
                exception.getMessage()
        );

        then(costumerRepository).should(never()).deleteById(any());
    }

    @Test
    void shouldThrowExceptionWhenCostumerDoesNotExistOnUpdate() {
        Long id = 1L;

        CostumerRequest costumerRequest = mock(CostumerRequest.class);

        given(costumerRepository.findById(id))
                .willReturn(Optional.empty());

        CostumerException exception = Assertions.assertThrows(
                CostumerException.class, () -> costumerService.updateCostumer(id, costumerRequest)
        );

        Assertions.assertEquals(
                "Não existe cliente com este id!",
                exception.getMessage()
        );
    }

    @Test
    void shouldThrowExceptionWhenUpdateRequestIsInvalid() {
        Long id = 1L;
        CostumerRequest costumerRequest = mock(CostumerRequest.class);

        willThrow(new CostumerException("Dados inválidos"))
                .given(validator)
                .validate(costumerRequest);

        CostumerException exception = Assertions.assertThrows(
                CostumerException.class,
                () -> costumerService.updateCostumer(id, costumerRequest)
        );

        Assertions.assertEquals("Dados inválidos", exception.getMessage());

        then(costumerRepository).shouldHaveNoInteractions();
    }

    @Test
    void shouldUpdateCostumerWhenIdExists() {
        Long id = 1L;

        CostumerRequest costumerRequest = new CostumerRequest(
                "João Atualizado",
                "792.580.360-69",
                "joao_atualizado@gmail.com",
                "15997774142"
        );

        Costumer costumer = spy(new Costumer());

        given(costumerRepository.findById(id))
                .willReturn(Optional.of(costumer));

        costumerService.updateCostumer(id, costumerRequest);

        then(validator).should().validate(costumerRequest);
        then(costumer).should().updateCostumer(costumerRequest);
    }
}