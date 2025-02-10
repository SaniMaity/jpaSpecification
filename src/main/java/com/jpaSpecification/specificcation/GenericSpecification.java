package com.jpaSpecification.specificcation;

import com.jpaSpecification.controller.ResourceController;
import com.jpaSpecification.dto.AbstractDto;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.*;

public class GenericSpecification<T> implements Specification<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericSpecification.class);
    private final Map<String, Object> filters;
    private static final Set<String> abstractDtoFields = getAbstractDtoFields();

    public GenericSpecification(Map<String, Object> filters) {
        // Keep only filters that exist in AbstractDto
        this.filters = new HashMap<>();
        filters.forEach((key, value) -> {
            if (abstractDtoFields.contains(key) && value != null) {
                this.filters.put(key, value);
            }
        });
        logger.info("applicable filters are: {}",this.filters);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String field = entry.getKey();
            Object value = entry.getValue();

            if (value != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(field), value));
            }
        }

        return predicate;
    }

    /**
     * Extracts field names from AbstractDto dynamically
     */
    private static Set<String> getAbstractDtoFields() {
        Set<String> fieldNames = new HashSet<>();
        for (Field field : AbstractDto.class.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        logger.info("fieldNames are: {}",fieldNames);
        return fieldNames;
    }
}
