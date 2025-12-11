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
import com.sct.system.dto.SystemConfigBasicDto;
import com.sct.system.dto.SystemConfigDto;
import com.sct.system.dto.SystemConfigQueryDto;
import com.sct.system.entity.SystemConfig;
import com.sct.system.repository.SystemConfigRepository;

@RestController
@RequestMapping("system-config")
public class SystemConfigController {

    @Autowired
    private SystemConfigRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createSystemConfig(@RequestBody SystemConfigDto dto) {
        SystemConfig createdEntity = dto.toCreatedEntity();
        SystemConfig savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<SystemConfigDto>> findAllSystemConfigBy(
            @ModelAttribute SystemConfigQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<SystemConfigDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<SystemConfig> page = repository.findAll(predicate, pageable);
            List<SystemConfigDto> dtos = page.getContent().stream()
                    .map(SystemConfigDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<SystemConfig> list = (List<SystemConfig>) repository.findAll(predicate, sort);
            List<SystemConfigDto> dtos = list.stream()
                    .map(SystemConfigDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<SystemConfigBasicDto>> findAllSystemConfigBasicBy(
            @ModelAttribute SystemConfigQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<SystemConfigBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<SystemConfig> page = repository.findAll(predicate, pageable);
            List<SystemConfigBasicDto> dtos = page.getContent().stream()
                    .map(SystemConfigBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<SystemConfig> list = (List<SystemConfig>) repository.findAll(predicate, sort);
            List<SystemConfigBasicDto> dtos = list.stream()
                    .map(SystemConfigBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countSystemConfigBy(@ModelAttribute SystemConfigQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<SystemConfigDto> getSystemConfigById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(SystemConfigDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateSystemConfigById(@PathVariable("id") Long id, @RequestBody SystemConfigDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSystemConfigById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}