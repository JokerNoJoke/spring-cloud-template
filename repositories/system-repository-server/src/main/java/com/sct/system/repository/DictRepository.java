package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Dict;

public interface DictRepository extends CrudRepository<Dict, Long>, QuerydslPredicateExecutor<Dict> {

}