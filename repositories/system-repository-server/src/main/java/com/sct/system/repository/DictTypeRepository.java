package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.DictType;

public interface DictTypeRepository extends CrudRepository<DictType, Long>, QuerydslPredicateExecutor<DictType> {

}
