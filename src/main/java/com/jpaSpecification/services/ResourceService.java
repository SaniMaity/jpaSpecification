package com.jpaSpecification.services;


import com.jpaSpecification.dto.ResourceDto;
import com.jpaSpecification.entity.Resource;
import com.jpaSpecification.mapperUtil.ResourceMapper;
import com.jpaSpecification.repository.ResourceRepository;
import com.jpaSpecification.specificcation.GenericSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    public Page<ResourceDto> getAllResources(Map<String, Object> filters, Pageable pageable) {
        Specification<Resource> spec = new GenericSpecification<>(filters);
        Page<Resource> resourcePage = resourceRepository.findAll(spec, pageable);
        return resourcePage.map(resourceMapper::toDto);
    }
}

