package com.sct.demo.controller.dto;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.sct.demo.entities.Demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoQueryDto {

    private Integer column1;
    private String column2;
    private Boolean column3;

    public Example<Demo> toExample() {
        Demo entity = new Demo();
        if (this.column1 != null) {
            entity.setColumn1(this.column1);
        }
        if (this.column2 != null) {
            entity.setColumn2(this.column2);
        }
        if (this.column3 != null) {
            entity.setColumn3(this.column3);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher("column2", ExampleMatcher.GenericPropertyMatchers.contains());
        return Example.of(entity, matcher);
    }
}