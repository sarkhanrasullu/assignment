package com.remotecella.assignment.controller.dto;

import com.remotecella.assignment.service.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResponseDtoMapper {

    ResponseDtoMapper INSTANCE = Mappers.getMapper(ResponseDtoMapper.class);

    ProductResponseDto toResponse(ProductDto entity);
}
