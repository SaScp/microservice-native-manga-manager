package ru.alex.userservice.util.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import ru.alex.userservice.util.exception.UserNotFoundException;

@Component
public class UserNotFoundHandler implements HandlerStrategy {
    @Override
    public ProblemDetail execute(RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @Override
    public Class<? extends RuntimeException> getExceptionClass() {
        return UserNotFoundException.class;
    }
}
