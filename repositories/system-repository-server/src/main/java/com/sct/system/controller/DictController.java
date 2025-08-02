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

import com.sct.system.controller.dto.DictBasicDto;
import com.sct.system.controller.dto.DictDto;
import com.sct.system.controller.dto.DictQueryDto;
import com.sct.system.entities.Dict;
import com.sct.system.repositories.DictRepository;

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
    public ResponseEntity<List<DictDto>> findAllDictBy(DictQueryDto dto) {
        List<Dict> list = repository.findAll(dto.toExample());
        List<DictDto> dtos = list.stream().map(DictDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<DictBasicDto>> findAllDictBasicBy(DictQueryDto dto) {
        List<Dict> list = repository.findAll(dto.toExample());
        List<DictBasicDto> dtos = list.stream().map(DictBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDictBy(DictQueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
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
                .map(dto::toUpdatedEntity)
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