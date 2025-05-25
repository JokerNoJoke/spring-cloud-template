package com.sct.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sct.demo.controller.dto.DemoDto;
import com.sct.demo.controller.dto.DemoQueryDto;
import com.sct.demo.entities.Demo;
import com.sct.demo.repositories.DemoRepository;

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
    public ResponseEntity<List<DemoDto>> findAllDemoBy(DemoQueryDto dto) {
        Example<Demo> example = dto.toExample();
        List<Demo> list = (List<Demo>) repository.findAll(example);
        List<DemoDto> dtos = list.stream().map(DemoDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllDemoBy(DemoQueryDto dto) {
        Example<Demo> example = dto.toExample();
        Long count = repository.count(example);
        return ResponseEntity.ok(count);
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
        return repository.findById(id).map(sourceEntity -> {
            Demo updatedEntity = dto.toUpdatedEntity(sourceEntity);
            repository.save(updatedEntity);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDemoById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
