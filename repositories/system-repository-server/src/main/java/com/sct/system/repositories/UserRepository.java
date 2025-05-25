package com.sct.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.system.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
