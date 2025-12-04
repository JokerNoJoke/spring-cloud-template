package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Org;

public interface OrgRepository extends CrudRepository<Org, Long>, QuerydslPredicateExecutor<Org> {

}