package com.jpaSpecification.controller;


import com.jpaSpecification.dto.ResourceDto;
import com.jpaSpecification.services.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/getAllResources")
    public ResponseEntity<Page<ResourceDto>> getAllResources(
            @RequestParam String testerName,  // Mandatory parameter
            @RequestParam(required = false) Map<String, Object> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {

        // Log the tester name
        logger.info("Request received from tester: {}", testerName);

        // Create Pageable with default sorting on "id"
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

        // Fetch and return resources with pagination & filtering
        Page<ResourceDto> result = resourceService.getAllResources(filters, pageable);
        return ResponseEntity.ok(result);
    }
}
