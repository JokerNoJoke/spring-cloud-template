package com.sct.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.demo.entities.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
