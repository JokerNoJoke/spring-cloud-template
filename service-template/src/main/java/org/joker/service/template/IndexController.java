package org.joker.service.template;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public Object index(HttpServletRequest request) {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(request.getHeaderNames().asIterator(), Spliterator.ORDERED), false)
                .collect(Collectors.toMap(s -> s, request::getHeader));
    }

}
