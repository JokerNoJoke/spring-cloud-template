package com.sct.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.system.entities.Org;

public interface OrgRepository extends JpaRepository<Org, Long> {
    // 自定义查询方法
}