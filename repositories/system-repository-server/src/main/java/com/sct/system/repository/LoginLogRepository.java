package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.LoginLog;

public interface LoginLogRepository extends CrudRepository<LoginLog, Long>, QuerydslPredicateExecutor<LoginLog> {

}
