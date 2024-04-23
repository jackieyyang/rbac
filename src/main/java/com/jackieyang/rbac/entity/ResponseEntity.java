package com.jackieyang.rbac.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Response code
     */
    private int code;

    /**
     * Response message
     */
    private String message;

    /**
     * Response data
     * disappear when the response data is empty
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * Response Common Method - Success with no data
     */
    public static <T> ResponseEntity<T> success() {
        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    /**
     * Response Common Method - Success with data
     */
    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    /**
     * Response Common Method - Created
     */
    public static <T> ResponseEntity<T> created() {
        return new ResponseEntity<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase(), null);
    }

    /**
     * Response Common Method - Bad Request
     */
    public static <T> ResponseEntity<T> badRequest() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
    }

    /**
     * Response Common Method - Internal Server Error
     */
    public static <T> ResponseEntity<T> internalServerError() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);
    }

    /**
     * Response Common Method - Unauthorized
     */
    public static <T> ResponseEntity<T> unauthorized() {
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase(), null);
    }

    /**
     * Response Common Method - Forbidden
     */
    public static <T> ResponseEntity<T> forbidden() {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase(), null);
    }

}
