package com.jpaSpecification.mapperUtil;

import com.jpaSpecification.dto.RoleDto;
import com.jpaSpecification.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDto toDto(Role role);
    Role toEntity(RoleDto roleDto);
}
