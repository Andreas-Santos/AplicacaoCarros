package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.request.SalesmanRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SalesmanMapper {

    SalesmanDTO toDTO(Salesman salesman);

    List<SalesmanDTO> toDTO(List<Salesman> salesman);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "initialDate", ignore = true)
    Salesman toEntity(SalesmanRequest salesmanRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "initialDate", ignore = true)
    List<Salesman> toEntity(List<SalesmanRequest> salesmanRequest);
}
