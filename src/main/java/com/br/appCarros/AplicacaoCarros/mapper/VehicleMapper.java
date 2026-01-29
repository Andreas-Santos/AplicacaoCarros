package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.VehicleDTO;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.request.VehicleRequest;
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
    Vehicle toEntity(VehicleRequest vehicleRequest);

    @Mapping(target = "id", ignore = true)
    List<Vehicle> toEntity(List<VehicleRequest> vehicleRequest);
}
