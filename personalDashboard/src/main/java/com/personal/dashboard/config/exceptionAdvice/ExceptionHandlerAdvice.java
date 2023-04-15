package com.personal.dashboard.config.exceptionAdvice;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.expection.ErrorResponse;
import com.personal.dashboard.exception.ApplicationException;
import com.personal.dashboard.exception.FileUploadException;
import com.personal.dashboard.exception.ValidationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice(basePackages = { "com.personal.dashboard" })
public class ExceptionHandlerAdvice {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler({ ValidationException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleValidationException(
            ValidationException ValidationException) {
        LOG.warn("ValidationException is thrown : ");
        // Create error response object.
        ErrorResponse errorResponse = new ErrorResponse(ValidationException.getErrorResponse().getCode(),
                ValidationException.getErrorResponse().getErrorText(), ValidationException.getValidationError(),
                ValidationException.getValidationErrorList());

        LOG.warn(errorResponse.toString());
        // Return error response with status.
        return new ResponseEntity<>(errorResponse, ValidationException.getErrorResponse().getHttpStatus());
    }

    @ExceptionHandler({ DuplicateKeyException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleDuplicatedKeyException(RuntimeException ex) {
        LOG.warn("DuplicateKeyException is thrown : ");
        // Create error response object.
        ErrorResponse errorResponse = new ErrorResponse(409, "Duplicate Record Error");

        LOG.warn(errorResponse.toString());
        // Return error response with status.
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ ApplicationException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleApplicationException(
            ApplicationException ApplicationException) {
        LOG.warn("RuntimeException is thrown : ");

        // Create error response object.
        ErrorResponse errorResponse = new ErrorResponse(ApplicationException.getErrorResponse().getCode(),
                ApplicationException.getErrorResponse().getErrorText());

        LOG.warn(errorResponse.toString());
        // Return error response with status.
        return new ResponseEntity<>(errorResponse, ApplicationException.getErrorResponse().getHttpStatus());
    }

    @ExceptionHandler({ ChangeSetPersister.NotFoundException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleNotFoundException(Throwable throwable) {
        LOG.warn(throwable.getMessage(), throwable);

        ErrorResponse errorResponse = new ErrorResponse(ErrorResponseEnum.INVALID_URL.getCode(),
                ErrorResponseEnum.INVALID_URL.getErrorText());
        LOG.error(errorResponse.toString());

        return new ResponseEntity<>(errorResponse, ErrorResponseEnum.INVALID_URL.getHttpStatus());
    }

    @ExceptionHandler({ Throwable.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleException(Throwable throwable) {
        LOG.error(throwable.getMessage(), throwable);

        ErrorResponse errorResponse = new ErrorResponse(ErrorResponseEnum.GENERAL_ERROR.getCode(),
                ErrorResponseEnum.GENERAL_ERROR.getErrorText());
        LOG.error(errorResponse.toString());

        return new ResponseEntity<>(errorResponse, ErrorResponseEnum.GENERAL_ERROR.getHttpStatus());
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleAccessDeniedException(Throwable throwable) {
        LOG.error(throwable.getMessage(), throwable);

        ErrorResponse errorResponse = new ErrorResponse(ErrorResponseEnum.ACCESS_DENIED.getCode(),
                ErrorResponseEnum.ACCESS_DENIED.getErrorText());
        LOG.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, ErrorResponseEnum.ACCESS_DENIED.getHttpStatus());
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
            Throwable throwable) {
        LOG.error(throwable.getMessage(), throwable);

        ErrorResponse errorResponse = new ErrorResponse(ErrorResponseEnum.DATA_MISSING.getCode(),
                ErrorResponseEnum.DATA_MISSING.getErrorText());
        LOG.error(errorResponse.toString());
        return new ResponseEntity<>(errorResponse, ErrorResponseEnum.DATA_MISSING.getHttpStatus());
    }

    @ExceptionHandler({ FileUploadException.class })
    public @ResponseBody ResponseEntity<ErrorResponse> handleTransactionException(
            FileUploadException fileUploadException) {
        LOG.warn("FileUploadException is thrown : ");
        // Create error response object.
        ErrorResponse errorResponse = new ErrorResponse(fileUploadException.getErrorResponse().getCode(),
                fileUploadException.getErrorResponse().getErrorText(), fileUploadException.getValidationError(),
                fileUploadException.getValidationErrorList());

        LOG.warn(errorResponse.toString());
        // Return error response with status.
        return new ResponseEntity<>(errorResponse, fileUploadException.getErrorResponse().getHttpStatus());
    }

}
