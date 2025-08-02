package com.sct.system.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.system.entities.Dict;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DictQueryDto {

    private String label;
    private String key;

    public Example<Dict> toExample() {
        Dict entity = new Dict();
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