package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.request.CreateVehicleRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VehicleMapper {

    VehicleDTO toDTO(Vehicle vehicle);

    List<VehicleDTO> toDTO(List<Vehicle> vehicles);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deal", ignore = true)
    Vehicle toEntity(CreateVehicleRequest vehicleRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deal", ignore = true)
    List<Vehicle> toEntity(List<CreateVehicleRequest> vehicleRequest);
}
