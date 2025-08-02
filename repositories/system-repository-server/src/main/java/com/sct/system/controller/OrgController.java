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

import com.sct.system.controller.dto.OrgBasicDto;
import com.sct.system.controller.dto.OrgDto;
import com.sct.system.controller.dto.OrgQueryDto;
import com.sct.system.entities.Org;
import com.sct.system.repositories.OrgRepository;

@RestController
@RequestMapping("org")
public class OrgController {

    @Autowired
    private OrgRepository repository;

    @PostMapping
    public ResponseEntity<Void> createOrg(@RequestBody OrgDto dto) {
        Org createdEntity = dto.toCreatedEntity();
        Org savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<OrgDto>> findAllOrgBy(OrgQueryDto dto) {
        List<Org> list = repository.findAll(dto.toExample());
        List<OrgDto> dtos = list.stream().map(OrgDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<OrgBasicDto>> findAllOrgBasicBy(OrgQueryDto dto) {
        List<Org> list = repository.findAll(dto.toExample());
        List<OrgBasicDto> dtos = list.stream().map(OrgBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllOrgBy(OrgQueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrgDto> findOrgById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(OrgDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateOrgById(@PathVariable("id") Long id, @RequestBody OrgDto dto) {
        return repository.findById(id)
                .map(dto::toUpdatedEntity)
                .map(repository::save)
                .map(__ -> ResponseEntity.ok().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrgById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }
}