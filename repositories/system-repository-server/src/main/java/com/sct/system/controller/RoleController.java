package com.sct.system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.system.controller.dto.RoleBasicDto;
import com.sct.system.controller.dto.RoleDto;
import com.sct.system.controller.dto.RoleQueryDto;
import com.sct.system.entities.Role;
import com.sct.system.repositories.RoleRepository;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody RoleDto dto) {
        Role createdEntity = dto.toCreatedEntity();
        Role savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> findAllRoleBy(RoleQueryDto dto) {
        List<Role> list = (List<Role>) repository.findAll(dto.toExample());
        List<RoleDto> dtos = list.stream().map(RoleDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<RoleBasicDto>> findAllRoleBasicBy(RoleQueryDto dto) {
        List<Role> list = repository.findAll(dto.toExample());
        List<RoleBasicDto> dtos = list.stream().map(RoleBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllRoleBy(RoleQueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoleDto> findRoleById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(RoleDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateRoleById(@PathVariable("id") Long id, @RequestBody RoleDto dto) {
        return repository.findById(id).map(sourceEntity -> {
            Role updatedEntity = dto.toUpdatedEntity(sourceEntity);
            repository.save(updatedEntity);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}