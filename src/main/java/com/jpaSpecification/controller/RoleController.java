package com.jpaSpecification.controller;

import com.jpaSpecification.dto.RoleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jpaSpecification.services.RoleService;
import java.util.Map;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @GetMapping("/getAllRoles")
    public ResponseEntity<Page<RoleDto>> getAllRoles(
            @RequestParam String testerName,  // Mandatory parameter
            @RequestParam(required = false) Map<String, Object> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {

        // Log the tester name
        logger.info("Tester: {}, Filters: {}", testerName, filters);

        // Create Pageable with default sorting on "id"
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

        // Fetch and return roles with pagination & filtering
        Page<RoleDto> result = roleService.getAllRoles(filters, pageable);
        return ResponseEntity.ok(result);
    }
}