package com.remotecella.assignment.service.dto;

import com.remotecella.assignment.repository.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceDtoMapper {

    ServiceDtoMapper INSTANCE = Mappers.getMapper(ServiceDtoMapper.class);

    ProductDto toDto(ProductEntity entity);
    ProductEntity toEntity(ProductDto dto);

}
