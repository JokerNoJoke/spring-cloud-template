package com.sct.demo.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDto<T> {

    private List<T> content;
    private Long totalElements;
    private Integer totalPages;

}