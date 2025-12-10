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

    @PostMapping
    public ResponseEntity<Void> createTenant(@RequestBody TenantDto dto) {
        Tenant createdEntity = dto.toCreatedEntity();
        Tenant savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<TenantDto>> findAllTenantBy(@ModelAttribute TenantQueryDto dto) {
        List<Tenant> list = (List<Tenant>) repository.findAll(dto.toPredicate());
        List<TenantDto> dtos = list.stream().map(TenantDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<TenantBasicDto>> findAllTenantBasicBy(@ModelAttribute TenantQueryDto dto) {
        List<Tenant> list = (List<Tenant>) repository.findAll(dto.toPredicate());
        List<TenantBasicDto> dtos = list.stream().map(TenantBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllTenantBy(@ModelAttribute TenantQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<TenantDto>> findAllTenantPageBy(
            @ModelAttribute TenantQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Tenant> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<TenantDto> dtos = page.getContent().stream()
                .map(TenantDto::fromEntity)
                .toList();
        PageResponseDto<TenantDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<TenantDto> findTenantById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(TenantDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateTenantById(@PathVariable("id") Long id, @RequestBody TenantDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTenantById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
