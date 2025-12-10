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

    @PostMapping
    public ResponseEntity<Void> createLoginLog(@RequestBody LoginLogDto dto) {
        LoginLog createdEntity = dto.toCreatedEntity();
        LoginLog savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<LoginLogDto>> findAllLoginLogBy(@ModelAttribute LoginLogQueryDto dto) {
        List<LoginLog> list = (List<LoginLog>) repository.findAll(dto.toPredicate());
        List<LoginLogDto> dtos = list.stream().map(LoginLogDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<LoginLogBasicDto>> findAllLoginLogBasicBy(@ModelAttribute LoginLogQueryDto dto) {
        List<LoginLog> list = (List<LoginLog>) repository.findAll(dto.toPredicate());
        List<LoginLogBasicDto> dtos = list.stream().map(LoginLogBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllLoginLogBy(@ModelAttribute LoginLogQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<LoginLogDto>> findAllLoginLogPageBy(
            @ModelAttribute LoginLogQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<LoginLog> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<LoginLogDto> dtos = page.getContent().stream()
                .map(LoginLogDto::fromEntity)
                .toList();
        PageResponseDto<LoginLogDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<LoginLogDto> findLoginLogById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(LoginLogDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateLoginLogById(@PathVariable("id") Long id, @RequestBody LoginLogDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLoginLogById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
