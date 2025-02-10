package com.jpaSpecification.services;

import com.jpaSpecification.dto.RoleDto;
import com.jpaSpecification.entity.Role;
import com.jpaSpecification.mapperUtil.RoleMapper;
import com.jpaSpecification.repository.RoleRepository;

import com.jpaSpecification.specificcation.GenericSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    public Page<RoleDto> getAllRoles(Map<String, Object> filters, Pageable pageable) {
        logger.info("Received filters: {}", filters);
        Specification<Role> spec = new GenericSpecification<>(filters);
        return roleRepository.findAll(spec, pageable).map(roleMapper::toDto);
    }
}
