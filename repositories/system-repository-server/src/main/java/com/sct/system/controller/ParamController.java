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
import com.sct.system.dto.ParamBasicDto;
import com.sct.system.dto.ParamDto;
import com.sct.system.dto.ParamQueryDto;
import com.sct.system.entity.Param;
import com.sct.system.repository.ParamRepository;

@RestController
@RequestMapping("param")
public class ParamController {

    @Autowired
    private ParamRepository repository;

    @PostMapping
    public ResponseEntity<Void> createParam(@RequestBody ParamDto dto) {
        Param createdEntity = dto.toCreatedEntity();
        Param savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<ParamDto>> findAllParamBy(@ModelAttribute ParamQueryDto dto) {
        List<Param> list = (List<Param>) repository.findAll(dto.toPredicate());
        List<ParamDto> dtos = list.stream().map(ParamDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<ParamBasicDto>> findAllParamBasicBy(@ModelAttribute ParamQueryDto dto) {
        List<Param> list = (List<Param>) repository.findAll(dto.toPredicate());
        List<ParamBasicDto> dtos = list.stream().map(ParamBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllParamBy(@ModelAttribute ParamQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<ParamDto>> findAllParamPageBy(
            @ModelAttribute ParamQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Param> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<ParamDto> dtos = page.getContent().stream()
                .map(ParamDto::fromEntity)
                .toList();
        PageResponseDto<ParamDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ParamDto> findParamById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(ParamDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateParamById(@PathVariable("id") Long id, @RequestBody ParamDto dto) {
        return repository.findById(id)
                .map(dto::updateEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteParamById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}