package com.jpaSpecification.mapperUtil;

import com.jpaSpecification.dto.ResourceDto;
import com.jpaSpecification.entity.Resource;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResourceMapper {
    ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    ResourceDto toDto(Resource resource);
    Resource toEntity(ResourceDto resourceDto);
}