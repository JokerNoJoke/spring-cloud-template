package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long>, QuerydslPredicateExecutor<Menu> {

}
