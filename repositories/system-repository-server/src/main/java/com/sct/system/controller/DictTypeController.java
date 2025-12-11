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
import com.sct.system.dto.DictTypeBasicDto;
import com.sct.system.dto.DictTypeDto;
import com.sct.system.dto.DictTypeQueryDto;
import com.sct.system.entity.DictType;
import com.sct.system.repository.DictTypeRepository;

@RestController
@RequestMapping("dict-type")
public class DictTypeController {

    @Autowired
    private DictTypeRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createDictType(@RequestBody DictTypeDto dto) {
        DictType createdEntity = dto.toCreatedEntity();
        DictType savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<DictTypeDto>> findAllDictTypeBy(
            @ModelAttribute DictTypeQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<DictTypeDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<DictType> page = repository.findAll(predicate, pageable);
            List<DictTypeDto> dtos = page.getContent().stream()
                    .map(DictTypeDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<DictType> list = (List<DictType>) repository.findAll(predicate, sort);
            List<DictTypeDto> dtos = list.stream()
                    .map(DictTypeDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<DictTypeBasicDto>> findAllDictTypeBasicBy(
            @ModelAttribute DictTypeQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<DictTypeBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<DictType> page = repository.findAll(predicate, pageable);
            List<DictTypeBasicDto> dtos = page.getContent().stream()
                    .map(DictTypeBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<DictType> list = (List<DictType>) repository.findAll(predicate, sort);
            List<DictTypeBasicDto> dtos = list.stream()
                    .map(DictTypeBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countDictTypeBy(@ModelAttribute DictTypeQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<DictTypeDto> getDictTypeById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DictTypeDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateDictTypeById(@PathVariable("id") Long id, @RequestBody DictTypeDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDictTypeById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}