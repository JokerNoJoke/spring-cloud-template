package com.sct.demo.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.demo.entity.Demo;

public interface DemoRepository extends CrudRepository<Demo, Long>, QuerydslPredicateExecutor<Demo> {

}
