package com.personal.dashboard.exception;



import com.personal.dashboard.domain.enums.ErrorResponseEnum;

import java.util.List;

public class FileUploadException extends ApplicationException {
    // To throw multiple errors.
    private List<ValidationError> validationErrorList;

    // To throw single error.
    private ValidationError validationError;

    public FileUploadException(List<ValidationError> validationErrorList, ErrorResponseEnum errorResponse) {
        super(errorResponse);
        this.validationErrorList = validationErrorList;
    }

    public FileUploadException(List<ValidationError> validationErrorList, ErrorResponseEnum errorResponse,
                               Throwable throwable) {
        super(errorResponse, throwable);
        this.validationErrorList = validationErrorList;
    }

    public FileUploadException(ValidationError validationError, ErrorResponseEnum errorResponse) {
        super(errorResponse);
        this.validationError = validationError;
    }

    public FileUploadException(ValidationError validationError, ErrorResponseEnum errorResponse, Throwable throwable) {
        super(errorResponse, throwable);
        this.validationError = validationError;
    }

    public List<ValidationError> getValidationErrorList() {
        return validationErrorList;
    }

    public void setValidationErrorList(List<ValidationError> validationErrorList) {
        this.validationErrorList = validationErrorList;
    }

    public ValidationError getValidationError() {
        return validationError;
    }

    public void setValidationError(ValidationError validationError) {
        this.validationError = validationError;
    }
}
