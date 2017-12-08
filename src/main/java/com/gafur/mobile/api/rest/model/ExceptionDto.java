package com.gafur.mobile.api.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import static java.util.Objects.nonNull;

/**
 * Модель для исключений
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@ApiModel(value = "ExceptionDto", description = "Exception Response `success = false`")
public class ExceptionDto {

    @JsonIgnore
    private Exception ex;
    @JsonIgnore
    private HttpStatus httpStatus;

    private String error;
    private String message;
    private String cause;

    /**
     * For exceptions with HttpStatus
     */
    public ExceptionDto(Exception ex, HttpStatus status) {
        setEx(ex);
        setError(ex.getClass().getSimpleName());
        setMessage(ex.getMessage());
        setCause(nonNull(ex.getCause()) ? ex.getCause().getMessage() : null);
        setHttpStatus(status);
        log.error(ex.getMessage(), ex);
    }

    /**
     * For all exceptions
     */
    public ExceptionDto(Exception ex) {
        setEx(ex);
        setError(ex.getClass().getSimpleName());
        setMessage(ex.getMessage());
        setCause(nonNull(ex.getCause()) ? ex.getCause().getMessage() : null);
        log.error(ex.getMessage(), ex);
    }
}
