package com.personal.dashboard.validation;

import com.personal.dashboard.domain.enums.ValidationErrorType;
import com.personal.dashboard.domain.userInfo.UserInfo;
import com.personal.dashboard.exception.ValidationError;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoValidator {

    public static List<ValidationError> validateInsert(final UserInfo userInfo) {
        List<ValidationError> validationErrorList = new ArrayList<>();

        if (StringUtils.isEmpty(userInfo.getEmail())) {
            validationErrorList.add(new ValidationError("'Email' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        if (StringUtils.isEmpty(userInfo.getUsername())) {
            validationErrorList.add(new ValidationError("'Username' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        if (StringUtils.isEmpty(userInfo.getPassword())) {
            validationErrorList.add(new ValidationError("'Password' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        if (StringUtils.isEmpty(userInfo.getFullName())) {
            validationErrorList.add(new ValidationError("'Full name' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        if (StringUtils.isEmpty(userInfo.getPrimaryRole())) {
            validationErrorList.add(new ValidationError("'Primary Role' cannot be Empty",
                    ValidationErrorType.REQUIRED_FIELD_MISSING.getErrorType()));
        }

        return validationErrorList;
    }
}
