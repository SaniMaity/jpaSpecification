package com.jpaSpecification.repository;

import com.jpaSpecification.entity.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResourceRepository extends CrudRepository<Resource, Long>,
                                            PagingAndSortingRepository<Resource, Long>,
                                            JpaSpecificationExecutor<Resource> {

}
