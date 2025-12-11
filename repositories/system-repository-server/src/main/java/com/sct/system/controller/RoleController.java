package com.sct.system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.sct.system.common.PageRequestDto;
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

    // Create
    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody RoleDto dto) {
        Role createdEntity = dto.toCreatedEntity();
        Role savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<RoleDto>> findAllRoleBy(
            @ModelAttribute RoleQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<RoleDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Role> page = repository.findAll(predicate, pageable);
            List<RoleDto> dtos = page.getContent().stream()
                    .map(RoleDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Role> list = (List<Role>) repository.findAll(predicate, sort);
            List<RoleDto> dtos = list.stream()
                    .map(RoleDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<RoleBasicDto>> findAllRoleBasicBy(
            @ModelAttribute RoleQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<RoleBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Role> page = repository.findAll(predicate, pageable);
            List<RoleBasicDto> dtos = page.getContent().stream()
                    .map(RoleBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Role> list = (List<Role>) repository.findAll(predicate, sort);
            List<RoleBasicDto> dtos = list.stream()
                    .map(RoleBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countRoleBy(@ModelAttribute RoleQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(RoleDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateRoleById(@PathVariable("id") Long id, @RequestBody RoleDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoleById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}