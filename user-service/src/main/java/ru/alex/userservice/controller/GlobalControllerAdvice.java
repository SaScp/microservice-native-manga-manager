package ru.alex.userservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.alex.userservice.util.exception.UserNotFoundException;
import ru.alex.userservice.util.exception.handler.HandlerStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalControllerAdvice {

    private final Map<Class<? extends RuntimeException>, HandlerStrategy> handlers;

    public GlobalControllerAdvice(List<HandlerStrategy> handlerStrategyList) {
        handlers = new HashMap<>();
        for (var handler : handlerStrategyList) {
            handlers.put(handler.getExceptionClass(), handler);
        }
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ProblemDetail> exHandler(RuntimeException exception) {
        ProblemDetail problemDetail = handlers.get(exception.getClass()).execute(exception);
        return ResponseEntity
                .status(problemDetail.getStatus())
                .body(problemDetail);
    }
}
