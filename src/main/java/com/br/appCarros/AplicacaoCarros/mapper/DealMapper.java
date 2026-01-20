package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DealMapper {

    DealDTO toDTO(Deal deal);

    List<DealDTO> toDTO(List<Deal> deals);

//    Deal toEntity(DealDTO dealDTO);
//
//    List<Deal> toEntity(List<DealDTO> dealDTO);
}
