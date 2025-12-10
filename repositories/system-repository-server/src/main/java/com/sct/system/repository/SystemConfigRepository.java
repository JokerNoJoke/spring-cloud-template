package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.SystemConfig;

public interface SystemConfigRepository
                extends CrudRepository<SystemConfig, Long>, QuerydslPredicateExecutor<SystemConfig> {

}