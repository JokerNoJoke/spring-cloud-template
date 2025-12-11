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
import com.sct.system.dto.OperationLogBasicDto;
import com.sct.system.dto.OperationLogDto;
import com.sct.system.dto.OperationLogQueryDto;
import com.sct.system.entity.OperationLog;
import com.sct.system.repository.OperationLogRepository;

@RestController
@RequestMapping("operation-log")
public class OperationLogController {

    @Autowired
    private OperationLogRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createOperationLog(@RequestBody OperationLogDto dto) {
        OperationLog createdEntity = dto.toCreatedEntity();
        OperationLog savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<OperationLogDto>> findAllOperationLogBy(
            @ModelAttribute OperationLogQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<OperationLogDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<OperationLog> page = repository.findAll(predicate, pageable);
            List<OperationLogDto> dtos = page.getContent().stream()
                    .map(OperationLogDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<OperationLog> list = (List<OperationLog>) repository.findAll(predicate, sort);
            List<OperationLogDto> dtos = list.stream()
                    .map(OperationLogDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<OperationLogBasicDto>> findAllOperationLogBasicBy(
            @ModelAttribute OperationLogQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<OperationLogBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<OperationLog> page = repository.findAll(predicate, pageable);
            List<OperationLogBasicDto> dtos = page.getContent().stream()
                    .map(OperationLogBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<OperationLog> list = (List<OperationLog>) repository.findAll(predicate, sort);
            List<OperationLogBasicDto> dtos = list.stream()
                    .map(OperationLogBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countOperationLogBy(@ModelAttribute OperationLogQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<OperationLogDto> getOperationLogById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(OperationLogDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateOperationLogById(@PathVariable("id") Long id, @RequestBody OperationLogDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOperationLogById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
