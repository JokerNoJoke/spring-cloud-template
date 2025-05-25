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

import com.sct.system.controller.dto.UserBasicDto;
import com.sct.system.controller.dto.UserDto;
import com.sct.system.controller.dto.UserQueryDto;
import com.sct.system.entities.User;
import com.sct.system.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserDto dto) {
        User createdEntity = dto.toCreatedEntity();
        User savedEntity = repository.save(createdEntity);
        return ResponseEntity.created(URI.create(savedEntity.getId().toString())).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUserBy(UserQueryDto dto) {
        List<User> list = repository.findAll(dto.toExample());
        List<UserDto> dtos = list.stream().map(UserDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("basic")
    public ResponseEntity<List<UserBasicDto>> findAllUserBasicBy(UserQueryDto dto) {
        List<User> list = repository.findAll(dto.toExample());
        List<UserBasicDto> dtos = list.stream().map(UserBasicDto::fromEntity).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("count")
    public ResponseEntity<Long> countAllUserBy(UserQueryDto dto) {
        Long count = repository.count(dto.toExample());
        return ResponseEntity.ok(count);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(UserDto::fromEntity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") Long id, @RequestBody UserDto dto) {
        return repository.findById(id).map(sourceEntity -> {
            User updatedEntity = dto.toUpdatedEntity(sourceEntity);
            repository.save(updatedEntity);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().<Void>build();
    }

}
