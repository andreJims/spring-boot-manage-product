package com.dev.api.api.infrastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.dev.api.api.exceptions.FunctionalInvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(FunctionalInvalidDataException.class)
    public final ResponseEntity<Map<String, String>> handleValidationException(FunctionalInvalidDataException e,
                                                                               WebRequest request) {
        String uuid = UUID.randomUUID().toString();
        log.error("Validation Error ID {} ", uuid, e);

        Map<String, String> mapErrors = new HashMap<>();
        mapErrors.put("uuid", uuid);
        mapErrors.put("errorMessage", e.getMessage());
        return new ResponseEntity<>(mapErrors, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}