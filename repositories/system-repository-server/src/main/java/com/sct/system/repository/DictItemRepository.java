package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.DictItem;

public interface DictItemRepository extends CrudRepository<DictItem, Long>, QuerydslPredicateExecutor<DictItem> {

}
