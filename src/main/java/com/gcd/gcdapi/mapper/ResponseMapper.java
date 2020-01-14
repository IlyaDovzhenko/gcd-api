package com.gcd.gcdapi.mapper;

import com.gcd.gcdapi.model.ResponseData;
import com.gcd.gcdapi.model.dto.ResponseDataDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ResponseMapper {
    ResponseDataDto toRequestDataDTO(ResponseData responseData);
    Set<ResponseDataDto> toRequestDataDTOs(Set<ResponseData> responseDataSet);
    ResponseData toRequestData(ResponseDataDto requestDataDto);
}
