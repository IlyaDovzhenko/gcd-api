package com.gcd.gcdapi.mapper;

import com.gcd.gcdapi.model.RequestData;
import com.gcd.gcdapi.model.dto.RequestDataDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RequestMapper {
    RequestDataDto toRequestDataDTO(RequestData requestData);
    Set<RequestDataDto> toRequestDataDTOs(Set<RequestData> requestDataSet);
    RequestData toRequestData(RequestDataDto requestDataDto);
}
