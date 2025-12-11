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
import com.sct.system.dto.TenantBasicDto;
import com.sct.system.dto.TenantDto;
import com.sct.system.dto.TenantQueryDto;
import com.sct.system.entity.Tenant;
import com.sct.system.repository.TenantRepository;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createTenant(@RequestBody TenantDto dto) {
        Tenant createdEntity = dto.toCreatedEntity();
        Tenant savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<TenantDto>> findAllTenantBy(
            @ModelAttribute TenantQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<TenantDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Tenant> page = repository.findAll(predicate, pageable);
            List<TenantDto> dtos = page.getContent().stream()
                    .map(TenantDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Tenant> list = (List<Tenant>) repository.findAll(predicate, sort);
            List<TenantDto> dtos = list.stream()
                    .map(TenantDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<TenantBasicDto>> findAllTenantBasicBy(
            @ModelAttribute TenantQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<TenantBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Tenant> page = repository.findAll(predicate, pageable);
            List<TenantBasicDto> dtos = page.getContent().stream()
                    .map(TenantBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Tenant> list = (List<Tenant>) repository.findAll(predicate, sort);
            List<TenantBasicDto> dtos = list.stream()
                    .map(TenantBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countTenantBy(@ModelAttribute TenantQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(TenantDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateTenantById(@PathVariable("id") Long id, @RequestBody TenantDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTenantById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
