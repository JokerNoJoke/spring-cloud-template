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

    @PostMapping
    public ResponseEntity<Void> createDictType(@RequestBody DictTypeDto dto) {
        DictType createdEntity = dto.toCreatedEntity();
        DictType savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<DictTypeDto>> findAllDictTypeBy(@ModelAttribute DictTypeQueryDto dto) {
        List<DictType> list = (List<DictType>) repository.findAll(dto.toPredicate());
        List<DictTypeDto> dtos = list.stream().map(DictTypeDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<DictTypeBasicDto>> findAllDictTypeBasicBy(@ModelAttribute DictTypeQueryDto dto) {
        List<DictType> list = (List<DictType>) repository.findAll(dto.toPredicate());
        List<DictTypeBasicDto> dtos = list.stream().map(DictTypeBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDictTypeBy(@ModelAttribute DictTypeQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<DictTypeDto>> findAllDictTypePageBy(
            @ModelAttribute DictTypeQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<DictType> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<DictTypeDto> dtos = page.getContent().stream()
                .map(DictTypeDto::fromEntity)
                .toList();
        PageResponseDto<DictTypeDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<DictTypeDto> findDictTypeById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DictTypeDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDictTypeById(@PathVariable("id") Long id, @RequestBody DictTypeDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDictTypeById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}