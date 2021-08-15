package com.remotecella.assignment.controller.dto;

import com.remotecella.assignment.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RequestDtoMapper {

    RequestDtoMapper INSTANCE = Mappers.getMapper(RequestDtoMapper.class);
    ProductDto toServiceDto(ProductRequestDto request);
}
