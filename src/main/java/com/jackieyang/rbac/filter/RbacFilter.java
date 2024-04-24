package com.jackieyang.rbac.filter;

import com.jackieyang.rbac.annotation.RbacIgnore;
import com.jackieyang.rbac.entity.vo.UserRolePermissionVO;
import com.jackieyang.rbac.service.RbacService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class RbacFilter implements HandlerInterceptor {

    private final RbacService rbacService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // exclude specific request path
        if (isExclude(request.getRequestURI())) {
            return true;
        };

        // pass if contains "RbacIgnore" in the request method
        if (handler instanceof HandlerMethod handlerMethod) {
            RbacIgnore rbacIgnore = handlerMethod.getMethodAnnotation(RbacIgnore.class);
            if (rbacIgnore != null) {
                return true;
            }
        }

        // get authorization from database
        UserRolePermissionVO userRolePermission = rbacService.queryUserRolePermission(2L);

        // authorization check
        rbacService.authorization(request.getRequestURI(), request.getMethod(), userRolePermission);
        return true;

    }

    private Boolean isExclude(String servletPath) {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (antPathMatcher.match("/doc.html", servletPath) ||
            antPathMatcher.match("/webjars/**", servletPath) ||
            antPathMatcher.matchStart("/favicon.ico", servletPath) ||
            antPathMatcher.match("/v3/api-docs/**", servletPath)) {
            return true;
        }
        return false;
    }
}
