package com.br.appCarros.AplicacaoCarros.mapper;

import com.br.appCarros.AplicacaoCarros.dto.DealDTO;
import com.br.appCarros.AplicacaoCarros.model.Costumer;
import com.br.appCarros.AplicacaoCarros.model.Deal;
import com.br.appCarros.AplicacaoCarros.model.Salesman;
import com.br.appCarros.AplicacaoCarros.model.Vehicle;
import com.br.appCarros.AplicacaoCarros.request.CreateDealRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface DealMapper {

    DealDTO toDTO(Deal deal);

    List<DealDTO> toDTO(List<Deal> deals);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vehicle", ignore = true)
    @Mapping(target = "salesman", ignore = true)
    @Mapping(target = "costumer", ignore = true)
    @Mapping(target = "dealDate", ignore = true)
    Deal toEntity(CreateDealRequest salesmanRequest);
}
