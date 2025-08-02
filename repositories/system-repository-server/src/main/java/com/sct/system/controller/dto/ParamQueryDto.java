package com.sct.system.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.system.entities.Param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamQueryDto {

    private String label;
    private String key;

    public Example<Param> toExample() {
        Param entity = new Param();
        if (this.label != null) {
            entity.setLabel(this.label);
        }
        if (this.key != null) {
            entity.setKey(this.key);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher("label", ExampleMatcher.GenericPropertyMatchers.contains())
            .withMatcher("key", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(entity, matcher);
    }
}