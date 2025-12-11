package com.sct.demo.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequestDto {

    /**
     * ["field", "field,asc", "field,desc"]
     */
    private List<String> orders;
    private Integer pageNumber;
    private Integer pageSize;

    public boolean hasPagination() {
        return pageNumber != null && pageSize != null && pageNumber > 0 && pageSize > 0;
    }

    public Sort toSort() {
        if (orders != null && !orders.isEmpty()) {
            List<Sort.Order> sortOrders = new ArrayList<>(orders.size());
            for (String s : orders) {
                if (s == null || s.isBlank()) {
                    continue;
                }
                String[] split = s.split(",");
                String property = split[0];
                Sort.Direction direction;
                if (split.length == 1) {
                    direction = Sort.Direction.ASC;
                } else {
                    direction = Sort.Direction.fromOptionalString(split[1]).orElse(Sort.Direction.ASC);
                }
                sortOrders.add(new Sort.Order(direction, property));
            }
            if (!sortOrders.isEmpty()) {
                return Sort.by(sortOrders);
            }
        }
        return Sort.unsorted();
    }

    public Pageable toPageable() {
        Sort sort = toSort();
        if (pageNumber == null || pageSize == null || pageNumber < 1 || pageSize < 1) {
            throw new IllegalArgumentException("Page number and page size must be provided and greater than 0");
        }
        if (sort.isUnsorted()) {
            return PageRequest.of(pageNumber - 1, pageSize);
        } else {
            return PageRequest.of(pageNumber - 1, pageSize, sort);
        }
    }

}
