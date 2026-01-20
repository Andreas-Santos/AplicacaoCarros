package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.CostumerDTO;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CostumerMapper {

    CostumerDTO toDTO(Costumer costumer);

    List<CostumerDTO> toDTO(List<Costumer> costumers);

    @Mapping(target = "deals", ignore = true)
    Costumer toEntity(CostumerDTO costumer);

    @Mapping(target = "deals", ignore = true)
    List<Costumer> toEntity(List<CostumerDTO> costumer);
}
