package com.sct.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.system.entities.Dict;

public interface DictRepository extends JpaRepository<Dict, Long> {
    // 自定义查询方法
}