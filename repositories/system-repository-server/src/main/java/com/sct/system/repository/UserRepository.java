package com.sct.system.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sct.system.entity.User;

public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User> {

}
