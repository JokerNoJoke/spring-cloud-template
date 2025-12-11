package com.sct.demo.controller;

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
import com.sct.demo.common.PageRequestDto;
import com.sct.demo.common.PageResponseDto;
import com.sct.demo.dto.DemoDto;
import com.sct.demo.dto.DemoQueryDto;
import com.sct.demo.entity.Demo;
import com.sct.demo.repository.DemoRepository;

@RestController
@RequestMapping("demo")
public class DemoController {

    @Autowired
    private DemoRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createDemo(@RequestBody DemoDto dto) {
        Demo createdEntity = dto.toCreatedEntity();
        Demo savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<DemoDto>> findAllDemoBy(
            @ModelAttribute DemoQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<DemoDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Demo> page = repository.findAll(predicate, pageable);
            List<DemoDto> dtos = page.getContent().stream()
                    .map(DemoDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Demo> list = (List<Demo>) repository.findAll(predicate, sort);
            List<DemoDto> dtos = list.stream()
                    .map(DemoDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countDemoBy(@ModelAttribute DemoQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<DemoDto> getDemoById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DemoDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateDemoById(@PathVariable("id") Long id, @RequestBody DemoDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDemoById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
