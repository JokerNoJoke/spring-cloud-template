package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Tenant;

public interface TenantRepository extends CrudRepository<Tenant, Long>, QuerydslPredicateExecutor<Tenant> {

}
