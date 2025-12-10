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

    @PostMapping
    public ResponseEntity<Void> createOperationLog(@RequestBody OperationLogDto dto) {
        OperationLog createdEntity = dto.toCreatedEntity();
        OperationLog savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<OperationLogDto>> findAllOperationLogBy(@ModelAttribute OperationLogQueryDto dto) {
        List<OperationLog> list = (List<OperationLog>) repository.findAll(dto.toPredicate());
        List<OperationLogDto> dtos = list.stream().map(OperationLogDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<OperationLogBasicDto>> findAllOperationLogBasicBy(
            @ModelAttribute OperationLogQueryDto dto) {
        List<OperationLog> list = (List<OperationLog>) repository.findAll(dto.toPredicate());
        List<OperationLogBasicDto> dtos = list.stream().map(OperationLogBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllOperationLogBy(@ModelAttribute OperationLogQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<OperationLogDto>> findAllOperationLogPageBy(
            @ModelAttribute OperationLogQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<OperationLog> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<OperationLogDto> dtos = page.getContent().stream()
                .map(OperationLogDto::fromEntity)
                .toList();
        PageResponseDto<OperationLogDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<OperationLogDto> findOperationLogById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(OperationLogDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOperationLogById(@PathVariable("id") Long id, @RequestBody OperationLogDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOperationLogById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
