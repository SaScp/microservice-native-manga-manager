package ru.alex.userservice.util.exception.handler;

import org.springframework.http.ProblemDetail;
import org.springframework.web.context.request.WebRequest;

public interface HandlerStrategy {

    ProblemDetail execute(RuntimeException exception);

    Class<? extends RuntimeException> getExceptionClass();
}
