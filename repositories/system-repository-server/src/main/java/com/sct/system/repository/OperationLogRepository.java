package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.OperationLog;

public interface OperationLogRepository
                extends CrudRepository<OperationLog, Long>, QuerydslPredicateExecutor<OperationLog> {

}
