package com.sct.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.system.entities.Param;

public interface ParamRepository extends JpaRepository<Param, Long> {
    // 自定义查询方法
}