package se.jensen.javacourse.week3.lukaskaarle.webapp.exceptionHandler;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler (value = {UnknownHostException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict (RuntimeException ex, WebRequest request) {
        String message = "Ooopsie, please enter a valid URI";
        return handleExceptionInternal(ex, message,
        new HttpHeaders(), HttpStatus.valueOf(400), request);
    }
}
