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
import com.sct.system.dto.LoginLogBasicDto;
import com.sct.system.dto.LoginLogDto;
import com.sct.system.dto.LoginLogQueryDto;
import com.sct.system.entity.LoginLog;
import com.sct.system.repository.LoginLogRepository;

@RestController
@RequestMapping("login-log")
public class LoginLogController {

    @Autowired
    private LoginLogRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createLoginLog(@RequestBody LoginLogDto dto) {
        LoginLog createdEntity = dto.toCreatedEntity();
        LoginLog savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<LoginLogDto>> findAllLoginLogBy(
            @ModelAttribute LoginLogQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<LoginLogDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<LoginLog> page = repository.findAll(predicate, pageable);
            List<LoginLogDto> dtos = page.getContent().stream()
                    .map(LoginLogDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<LoginLog> list = (List<LoginLog>) repository.findAll(predicate, sort);
            List<LoginLogDto> dtos = list.stream()
                    .map(LoginLogDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<LoginLogBasicDto>> findAllLoginLogBasicBy(
            @ModelAttribute LoginLogQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<LoginLogBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<LoginLog> page = repository.findAll(predicate, pageable);
            List<LoginLogBasicDto> dtos = page.getContent().stream()
                    .map(LoginLogBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<LoginLog> list = (List<LoginLog>) repository.findAll(predicate, sort);
            List<LoginLogBasicDto> dtos = list.stream()
                    .map(LoginLogBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countLoginLogBy(@ModelAttribute LoginLogQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<LoginLogDto> getLoginLogById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(LoginLogDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateLoginLogById(@PathVariable("id") Long id, @RequestBody LoginLogDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLoginLogById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
