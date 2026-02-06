package com.br.appCarros.AplicacaoCarros.service;

import com.br.appCarros.AplicacaoCarros.exception.VehicleException;
import com.br.appCarros.AplicacaoCarros.mapper.VehicleMapper;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.repository.VehicleRepository;
import com.br.appCarros.AplicacaoCarros.request.VehicleRequest;
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
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {
    @InjectMocks
    VehicleService vehicleService;

    @Mock
    VehicleRepository vehicleRepository;

    @Mock
    VehicleMapper vehicleMapper;

    @Mock
    VehicleRequest vehicleRequest;

    @Mock
    Vehicle vehicle;

    @Captor
    ArgumentCaptor<Vehicle> vehicleCaptor;

    @Test
    void shouldCreateVehicleWhenRequestIsValid() {
        vehicleRequest = mock(VehicleRequest.class);
        vehicle = mock(Vehicle.class);

        given(vehicleMapper.toEntity(vehicleRequest))
                .willReturn(vehicle);

        vehicleService.createVehicle(vehicleRequest);

        then(vehicleRepository).should().save(vehicleCaptor.capture());

        Vehicle createdVehicle = vehicleCaptor.getValue();

        Assertions.assertEquals(createdVehicle, vehicle);
    }

    @Test
    void shouldDeleteVehicleWhenIdExists() {
        Long id = 1L;

        vehicle = mock(Vehicle.class);

        given(vehicleRepository.findById(id))
                .willReturn(Optional.of(vehicle));

        vehicleService.deleteVehicle(id);

        then(vehicleRepository).should()
                .deleteById(id);
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExistsOnDelete() {
        Long id = 1L;

        given(vehicleRepository.findById(id))
                .willReturn(Optional.empty());

        VehicleException exception = Assertions.assertThrows(
                VehicleException.class, () -> vehicleService.deleteVehicle(id)
        );

        Assertions.assertEquals(
                "Não existe veículo com esse id!",
                exception.getMessage()
        );

        then(vehicleRepository).should(never())
                .deleteById(any());
    }
}''