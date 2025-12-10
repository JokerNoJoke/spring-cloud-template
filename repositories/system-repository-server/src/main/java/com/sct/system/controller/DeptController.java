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
import com.sct.system.dto.DeptBasicDto;
import com.sct.system.dto.DeptDto;
import com.sct.system.dto.DeptQueryDto;
import com.sct.system.entity.Dept;
import com.sct.system.repository.DeptRepository;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptRepository repository;

    @PostMapping
    public ResponseEntity<Void> createDept(@RequestBody DeptDto dto) {
        Dept createdEntity = dto.toCreatedEntity();
        Dept savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<DeptDto>> findAllDeptBy(@ModelAttribute DeptQueryDto dto) {
        List<Dept> list = (List<Dept>) repository.findAll(dto.toPredicate());
        List<DeptDto> dtos = list.stream().map(DeptDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<DeptBasicDto>> findAllDeptBasicBy(@ModelAttribute DeptQueryDto dto) {
        List<Dept> list = (List<Dept>) repository.findAll(dto.toPredicate());
        List<DeptBasicDto> dtos = list.stream().map(DeptBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDeptBy(@ModelAttribute DeptQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<DeptDto>> findAllDeptPageBy(
            @ModelAttribute DeptQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Dept> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<DeptDto> dtos = page.getContent().stream()
                .map(DeptDto::fromEntity)
                .toList();
        PageResponseDto<DeptDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<DeptDto> findDeptById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DeptDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDeptById(@PathVariable("id") Long id, @RequestBody DeptDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDeptById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}