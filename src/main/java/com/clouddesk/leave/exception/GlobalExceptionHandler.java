package com.clouddesk.leave.exception;

import com.clouddesk.leave.dto.response.ApiErrorResponse;
import jakarta.persistence.EntityExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(
            UsernameNotFoundException ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorResponse(
                        401,
                        "UNAUTHORIZED",
                        "Invalid email or password"
                ));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleBadCredentials(
            BadCredentialsException ex) {

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorResponse(
                        401,
                        "UNAUTHORIZED",
                        "Invalid email or password"
                ));
    }

    @ExceptionHandler(AccountExpiredException.class)
    public ResponseEntity<ApiErrorResponse> handleAccountExpired(
            AccountExpiredException ex) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ApiErrorResponse(
                        403,
                        "ACCOUNT_EXPIRED",
                        "Your account has expired. Please contact support."
                ));
    }

    // ============================
    // VALIDATION EXCEPTIONS
    // ============================

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        FieldError firstError = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .orElse(null);

        String message = firstError != null
                ? firstError.getField() + ": " + firstError.getDefaultMessage()
                : "Validation failed";

        return ResponseEntity.badRequest()
                .body(new ApiErrorResponse(
                        400,
                        "VALIDATION_ERROR",
                        message
                ));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiErrorResponse(
                        409,
                        "DATA_CONFLICT",
                        "The request could not be processed due to a data conflict."
                ));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleEntityExists(
            EntityExistsException ex) {

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ApiErrorResponse(
                        409,
                        "DATA_CONFLICT",
                        ex.getMessage() // return real reason
                ));
    }
    // ============================
    // FALLBACK (SAFE DEFAULT)
    // ============================

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(
            Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorResponse(
                        500,
                        "INTERNAL_SERVER_ERROR",
                        "Something went wrong. Please try again later."
                ));
    }
}
