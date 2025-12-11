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
import com.sct.system.dto.MenuBasicDto;
import com.sct.system.dto.MenuDto;
import com.sct.system.dto.MenuQueryDto;
import com.sct.system.entity.Menu;
import com.sct.system.repository.MenuRepository;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuRepository repository;

    // Create
    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody MenuDto dto) {
        Menu createdEntity = dto.toCreatedEntity();
        Menu savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    // Find All (List/Page)
    @GetMapping
    public ResponseEntity<PageResponseDto<MenuDto>> findAllMenuBy(
            @ModelAttribute MenuQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<MenuDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Menu> page = repository.findAll(predicate, pageable);
            List<MenuDto> dtos = page.getContent().stream()
                    .map(MenuDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Menu> list = (List<Menu>) repository.findAll(predicate, sort);
            List<MenuDto> dtos = list.stream()
                    .map(MenuDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Find All Basic (List/Page)
    @GetMapping("basic")
    public ResponseEntity<PageResponseDto<MenuBasicDto>> findAllMenuBasicBy(
            @ModelAttribute MenuQueryDto queryDto,
            @ModelAttribute PageRequestDto pageRequestDto) {
        Predicate predicate = queryDto.toPredicate();
        PageResponseDto<MenuBasicDto> response;
        if (pageRequestDto.hasPagination()) {
            Pageable pageable = pageRequestDto.toPageable();
            Page<Menu> page = repository.findAll(predicate, pageable);
            List<MenuBasicDto> dtos = page.getContent().stream()
                    .map(MenuBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, page.getTotalElements(), page.getTotalPages());
        } else {
            Sort sort = pageRequestDto.toSort();
            List<Menu> list = (List<Menu>) repository.findAll(predicate, sort);
            List<MenuBasicDto> dtos = list.stream()
                    .map(MenuBasicDto::fromEntity)
                    .toList();
            response = new PageResponseDto<>(dtos, Long.valueOf(list.size()), 1);
        }
        return ResponseEntity.ok(response);
    }

    // Count
    @GetMapping("count")
    public ResponseEntity<Long> countMenuBy(@ModelAttribute MenuQueryDto queryDto) {
        Predicate predicate = queryDto.toPredicate();
        Long count = repository.count(predicate);
        return ResponseEntity.ok(count);
    }

    // Get By Id
    @GetMapping("{id}")
    public ResponseEntity<MenuDto> getMenuById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(MenuDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("{id}")
    public ResponseEntity<Void> updateMenuById(@PathVariable("id") Long id, @RequestBody MenuDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMenuById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}
