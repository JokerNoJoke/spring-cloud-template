package com.sct.demo.controller;

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

import com.querydsl.core.types.Predicate;
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

    @PostMapping
    public ResponseEntity<Void> createDemo(@RequestBody DemoDto dto) {
        Demo createdEntity = dto.toCreatedEntity();
        Demo savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<DemoDto>> findAllDemoBy(@ModelAttribute DemoQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        List<Demo> list = (List<Demo>) repository.findAll(predicate);
        List<DemoDto> dtos = list.stream()
                .map(DemoDto::fromEntity)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDemoBy(@ModelAttribute DemoQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<DemoDto>> findAllDemoPageBy(
            @ModelAttribute DemoQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Predicate predicate = queryDto.toPredicate();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Demo> page = repository.findAll(predicate, pageable);

        List<DemoDto> dtos = page.getContent().stream()
                .map(DemoDto::fromEntity)
                .toList();
        PageResponseDto<DemoDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<DemoDto> findDemoById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DemoDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDemoById(@PathVariable("id") Long id, @RequestBody DemoDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDemoById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
