package com.gafur.mobile.api.util;

import com.gafur.mobile.api.rest.model.ExceptionDto;
import com.gafur.mobile.api.service.exception.HandleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Перехватывает сообщения об ошибках
 *
 * @author igafurov
 * @since 07.12.2017
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerInterceptor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleAllException(Exception ex) {
        return new ResponseEntity<>(new ExceptionDto(ex),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HandleException.class)
    public ResponseEntity<ExceptionDto> handleControllerExceptions(HandleException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception, exception.getHttpStatus());
        return new ResponseEntity<>(exceptionDto,
                exceptionDto.getHttpStatus());
    }
}
