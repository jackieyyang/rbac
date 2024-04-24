package com.jackieyang.rbac.exception;

import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ForbiddenExceptionHandler {

    /**
     * forbidden exception handler
     * throw a forbidden exception when the user is not authorized to access the resource
     * @param e forbidden exception
     * @return ResponseEntity<Object>
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = ForbiddenException.class)
    public ResponseEntity<Object> forbiddenException(ForbiddenException e) {
        return ResponseEntity.forbidden();
    }

}
