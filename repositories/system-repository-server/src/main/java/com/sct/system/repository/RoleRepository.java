package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>, QuerydslPredicateExecutor<Role> {

}
