package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.SalesmanDTO;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
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

    @Mapping(target = "deals", ignore = true)
    Salesman toEntity(SalesmanDTO salesmanDTO);

    @Mapping(target = "deals", ignore = true)
    List<Salesman> toEntity(List<SalesmanDTO>salesmanDTO);
}
