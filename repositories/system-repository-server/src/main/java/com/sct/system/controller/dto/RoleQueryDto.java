package com.sct.system.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.sct.system.entities.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleQueryDto {

    private String code;
    private String name;

    public Example<Role> toExample() {
        Role entity = new Role();
        if (this.code != null) {
            entity.setCode(this.code);
        }
        if (this.name != null) {
            entity.setName(this.name);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains())
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(entity, matcher);
    }
}