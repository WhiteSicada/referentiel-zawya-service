package com.referentiel.zawya.advice;

import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ControllerAdvice {

//    @ExceptionHandler(value = TokenRefreshException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ErrorMessage handleTokenRefreshException(TokenRefreshException ex, WebRequest request) {
//        return new ErrorMessage(
//                HttpStatus.FORBIDDEN.value(),
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false));
//    }
}
