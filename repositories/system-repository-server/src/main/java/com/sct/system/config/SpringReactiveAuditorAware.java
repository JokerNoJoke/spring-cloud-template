package com.sct.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.ReactiveAuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.sct.system.context.UserContext;

import reactor.core.publisher.Mono;

@Configuration
@EnableJpaAuditing
public class SpringReactiveAuditorAware implements ReactiveAuditorAware<Long> {

    @Override
    public Mono<Long> getCurrentAuditor() {
        return Mono.just(UserContext.getId());
    }

}
