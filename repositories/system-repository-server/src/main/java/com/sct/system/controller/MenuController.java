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

    @PostMapping
    public ResponseEntity<Void> createMenu(@RequestBody MenuDto dto) {
        Menu createdEntity = dto.toCreatedEntity();
        Menu savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<MenuDto>> findAllMenuBy(@ModelAttribute MenuQueryDto dto) {
        List<Menu> list = (List<Menu>) repository.findAll(dto.toPredicate());
        List<MenuDto> dtos = list.stream().map(MenuDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<MenuBasicDto>> findAllMenuBasicBy(@ModelAttribute MenuQueryDto dto) {
        List<Menu> list = (List<Menu>) repository.findAll(dto.toPredicate());
        List<MenuBasicDto> dtos = list.stream().map(MenuBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllMenuBy(@ModelAttribute MenuQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<MenuDto>> findAllMenuPageBy(
            @ModelAttribute MenuQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Menu> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<MenuDto> dtos = page.getContent().stream()
                .map(MenuDto::fromEntity)
                .toList();
        PageResponseDto<MenuDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<MenuDto> findMenuById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(MenuDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateMenuById(@PathVariable("id") Long id, @RequestBody MenuDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMenuById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
