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
import com.sct.system.dto.DictBasicDto;
import com.sct.system.dto.DictDto;
import com.sct.system.dto.DictQueryDto;
import com.sct.system.entity.Dict;
import com.sct.system.repository.DictRepository;

@RestController
@RequestMapping("dict")
public class DictController {

    @Autowired
    private DictRepository repository;

    @PostMapping
    public ResponseEntity<Void> createDict(@RequestBody DictDto dto) {
        Dict createdEntity = dto.toCreatedEntity();
        Dict savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<DictDto>> findAllDictBy(@ModelAttribute DictQueryDto dto) {
        List<Dict> list = (List<Dict>) repository.findAll(dto.toPredicate());
        List<DictDto> dtos = list.stream().map(DictDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<DictBasicDto>> findAllDictBasicBy(@ModelAttribute DictQueryDto dto) {
        List<Dict> list = (List<Dict>) repository.findAll(dto.toPredicate());
        List<DictBasicDto> dtos = list.stream().map(DictBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDictBy(@ModelAttribute DictQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<DictDto>> findAllDictPageBy(
            @ModelAttribute DictQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Dict> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<DictDto> dtos = page.getContent().stream()
                .map(DictDto::fromEntity)
                .toList();
        PageResponseDto<DictDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<DictDto> findDictById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DictDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDictById(@PathVariable("id") Long id, @RequestBody DictDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDictById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}