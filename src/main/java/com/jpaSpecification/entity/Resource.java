package com.jpaSpecification.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Resource extends AbstractEntity {
    private String resourceType;
}
