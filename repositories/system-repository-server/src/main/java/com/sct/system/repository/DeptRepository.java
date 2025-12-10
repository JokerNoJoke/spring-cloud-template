package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Dept;

public interface DeptRepository extends CrudRepository<Dept, Long>, QuerydslPredicateExecutor<Dept> {

}
