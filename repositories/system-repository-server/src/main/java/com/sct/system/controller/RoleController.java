package com.sct.system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sct.system.common.PageResponseDto;
import com.sct.system.dto.RoleBasicDto;
import com.sct.system.dto.RoleDto;
import com.sct.system.dto.RoleQueryDto;
import com.sct.system.entity.Role;
import com.sct.system.repository.RoleRepository;

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
    public ResponseEntity<List<RoleDto>> findAllRoleBy(@ModelAttribute RoleQueryDto dto) {
        List<Role> list = (List<Role>) repository.findAll(dto.toPredicate());
        List<RoleDto> dtos = list.stream().map(RoleDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<RoleBasicDto>> findAllRoleBasicBy(@ModelAttribute RoleQueryDto dto) {
        List<Role> list = (List<Role>) repository.findAll(dto.toPredicate());
        List<RoleBasicDto> dtos = list.stream().map(RoleBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllRoleBy(@ModelAttribute RoleQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<RoleDto>> findAllRolePageBy(
            @ModelAttribute RoleQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Role> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<RoleDto> dtos = page.getContent().stream()
                .map(RoleDto::fromEntity)
                .toList();
        PageResponseDto<RoleDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
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
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}