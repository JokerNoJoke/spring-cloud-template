package com.sct.system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.system.controller.dto.ParamDto;
import com.sct.system.controller.dto.ParamQueryDto;
import com.sct.system.entities.Param;
import com.sct.system.repositories.ParamRepository;

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
    public ResponseEntity<List<ParamDto>> findAllParamBy(ParamQueryDto dto) {
        List<Param> list = repository.findAll(dto.toExample());
        List<ParamDto> dtos = list.stream().map(ParamDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<ParamDto>> findAllParamBasicBy(ParamQueryDto dto) {
        List<Param> list = repository.findAll(dto.toExample());
        List<ParamDto> dtos = list.stream().map(ParamDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllParamBy(ParamQueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
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
                .map(dto::toUpdatedEntity)
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