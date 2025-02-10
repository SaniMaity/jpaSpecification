package com.jpaSpecification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractDto {
    private Long id;
    private String name;
    private String title;
    private String createdBy;
}
