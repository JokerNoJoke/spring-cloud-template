package com.sct.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sct.system.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
