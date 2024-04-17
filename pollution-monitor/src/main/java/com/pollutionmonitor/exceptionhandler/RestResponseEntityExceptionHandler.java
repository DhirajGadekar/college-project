package com.pollutionmonitor.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pollutionmonitor.exception.AirQuantityNoFoundForDate;
import com.pollutionmonitor.exception.EmailAlreadyExistsException;
import com.pollutionmonitor.exception.LoginCredentialWrongException;
import com.pollutionmonitor.exception.NullVlauesException;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> noSuchSupplierException(EmailAlreadyExistsException exception,
            WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.CONFLICT, exception.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(NullVlauesException.class)
    public ResponseEntity<ErrorMessage> noSuchSupplierException(NullVlauesException exception,
            WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(LoginCredentialWrongException.class)
    public ResponseEntity<ErrorMessage> noSuchSupplierException(LoginCredentialWrongException exception,
            WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.UNAUTHORIZED, exception.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    @ExceptionHandler(AirQuantityNoFoundForDate.class)
    public ResponseEntity<ErrorMessage> noSuchSupplierException(AirQuantityNoFoundForDate exception,
            WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}