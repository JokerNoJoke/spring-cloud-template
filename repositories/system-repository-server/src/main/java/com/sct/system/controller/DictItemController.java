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
import com.sct.system.dto.DictItemBasicDto;
import com.sct.system.dto.DictItemDto;
import com.sct.system.dto.DictItemQueryDto;
import com.sct.system.entity.DictItem;
import com.sct.system.repository.DictItemRepository;

@RestController
@RequestMapping("dict-item")
public class DictItemController {

    @Autowired
    private DictItemRepository repository;

    @PostMapping
    public ResponseEntity<Void> createDictItem(@RequestBody DictItemDto dto) {
        DictItem createdEntity = dto.toCreatedEntity();
        DictItem savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<DictItemDto>> findAllDictItemBy(@ModelAttribute DictItemQueryDto dto) {
        List<DictItem> list = (List<DictItem>) repository.findAll(dto.toPredicate());
        List<DictItemDto> dtos = list.stream().map(DictItemDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<DictItemBasicDto>> findAllDictItemBasicBy(@ModelAttribute DictItemQueryDto dto) {
        List<DictItem> list = (List<DictItem>) repository.findAll(dto.toPredicate());
        List<DictItemBasicDto> dtos = list.stream().map(DictItemBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDictItemBy(@ModelAttribute DictItemQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<DictItemDto>> findAllDictItemPageBy(
            @ModelAttribute DictItemQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<DictItem> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<DictItemDto> dtos = page.getContent().stream()
                .map(DictItemDto::fromEntity)
                .toList();
        PageResponseDto<DictItemDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<DictItemDto> findDictItemById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(DictItemDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateDictItemById(@PathVariable("id") Long id, @RequestBody DictItemDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDictItemById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
