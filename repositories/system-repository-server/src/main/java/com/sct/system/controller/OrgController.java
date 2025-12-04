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
import com.sct.system.dto.OrgBasicDto;
import com.sct.system.dto.OrgDto;
import com.sct.system.dto.OrgQueryDto;
import com.sct.system.entity.Org;
import com.sct.system.repository.OrgRepository;

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
    public ResponseEntity<List<OrgDto>> findAllOrgBy(@ModelAttribute OrgQueryDto dto) {
        List<Org> list = (List<Org>) repository.findAll(dto.toPredicate());
        List<OrgDto> dtos = list.stream().map(OrgDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<OrgBasicDto>> findAllOrgBasicBy(@ModelAttribute OrgQueryDto dto) {
        List<Org> list = (List<Org>) repository.findAll(dto.toPredicate());
        List<OrgBasicDto> dtos = list.stream().map(OrgBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllOrgBy(@ModelAttribute OrgQueryDto dto) {
        Long count = repository.count(dto.toPredicate());
        return ResponseEntity.ok(count);
    }

    @GetMapping("page")
    public ResponseEntity<PageResponseDto<OrgDto>> findAllOrgPageBy(
            @ModelAttribute OrgQueryDto queryDto,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<Org> page = repository.findAll(queryDto.toPredicate(), pageable);

        List<OrgDto> dtos = page.getContent().stream()
                .map(OrgDto::fromEntity)
                .toList();
        PageResponseDto<OrgDto> response = new PageResponseDto<>(
                dtos,
                page.getTotalElements(),
                page.getTotalPages());
        return ResponseEntity.ok(response);
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
                .map(dto::updateEntity)
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