package com.jpaSpecification.repository;

import com.jpaSpecification.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleRepository extends CrudRepository<Role, Long>,
                                        PagingAndSortingRepository<Role, Long>,
                                        JpaSpecificationExecutor<Role> {
}
