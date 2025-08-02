package com.sct.system.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.system.entities.Org;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrgQueryDto {

    private String name;

    public Example<Org> toExample() {
        Org entity = new Org();
        if (this.name != null) {
            entity.setName(this.name);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(entity, matcher);
    }
}