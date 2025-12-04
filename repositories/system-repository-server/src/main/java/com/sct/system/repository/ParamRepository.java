package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Param;

public interface ParamRepository extends CrudRepository<Param, Long>, QuerydslPredicateExecutor<Param> {

}