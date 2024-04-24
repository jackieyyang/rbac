package com.jackieyang.rbac.config;

import com.jackieyang.rbac.filter.RbacFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class RbacConfig implements WebMvcConfigurer {

    private final RbacFilter rbacFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rbacFilter)
                .order(5);
    }
}
