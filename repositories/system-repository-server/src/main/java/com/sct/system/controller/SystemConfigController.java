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

    @PostMapping
    public ResponseEntity<Void> createSystemConfig(@RequestBody SystemConfigDto dto) {
        SystemConfig createdEntity = dto.toCreatedEntity();
        SystemConfig savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<SystemConfigDto>> findAllSystemConfigBy(@ModelAttribute SystemConfigQueryDto dto) {
        List<SystemConfig> list = (List<SystemConfig>) repository.findAll(dto.toPredicate());
        List<SystemConfigDto> dtos = list.stream().map(SystemConfigDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<SystemConfigBasicDto>> findAllSystemConfigBasicBy(
            @ModelAttribute SystemConfigQueryDto dto) {
        List<SystemConfig> list = (List<SystemConfig>) repository.findAll(dto.toPredicate());
        List<SystemConfigBasicDto> dtos = list.stream().map(SystemConfigBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllSystemConfigBy(@ModelAttribute SystemConfigQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<SystemConfigDto>> findAllSystemConfigPageBy(
            @ModelAttribute SystemConfigQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<SystemConfig> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<SystemConfigDto> dtos = page.getContent().stream()
                .map(SystemConfigDto::fromEntity)
                .toList();
        PageResponseDto<SystemConfigDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<SystemConfigDto> findSystemConfigById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(SystemConfigDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSystemConfigById(@PathVariable("id") Long id, @RequestBody SystemConfigDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSystemConfigById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}