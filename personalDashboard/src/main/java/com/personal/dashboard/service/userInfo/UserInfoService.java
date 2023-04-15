package com.personal.dashboard.service.userInfo;

import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.userInfo.UserInfo;
import com.personal.dashboard.exception.ValidationError;
import com.personal.dashboard.exception.ValidationException;
import com.personal.dashboard.repository.userInfo.UserInfoRepository;
import com.personal.dashboard.validation.UserInfoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserInfoService.class);

    public List<UserInfo> getAllUsersService() {

        return userInfoRepository.getAllUsers();
    }

    public Page<UserInfo> getAllUsersPageService(Pageable page) {

        return userInfoRepository.getAllUsersPage(page);
    }

    public UserInfo insertUserService(UserInfo userInfo) {

        /* validation */
        List<ValidationError> validationErrorList = UserInfoValidator.validateInsert(userInfo);
        if (!validationErrorList.isEmpty()) {
            LOG.error("Could not insert user due to insufficient data.");
            throw new ValidationException(validationErrorList, ErrorResponseEnum.VALIDATION_ERROR);
        }

        return userInfoRepository.insertUser(userInfo);
    }

    public UserInfo getByIdService(String id) {

        if(StringUtils.isEmpty(id)) {

            throw new ValidationException(
                    new ValidationError("'UserInfo Id' missing", "Userinfo cannot be empty"),
                    ErrorResponseEnum.VALIDATION_ERROR);
        }

        return userInfoRepository.getById(id);
    }

    public UserInfo getByUsernameService(String username) {

        if(StringUtils.isEmpty(username)) {

            throw new ValidationException(
                    new ValidationError("'username' missing", "Provided username cannot be empty"),
                    ErrorResponseEnum.VALIDATION_ERROR);
        }

        return userInfoRepository.getByUsername(username);
    }

    public UserInfo updateUserInfoService(UserInfo userInfo) {

        if(StringUtils.isEmpty(userInfo.getId())) {

            throw new ValidationException(
                    new ValidationError("'id' missing", "'Id' cannot be empty"),
                    ErrorResponseEnum.VALIDATION_ERROR);
        }

        return userInfoRepository.updateUserInfo(userInfo);
    }

    public void deleteUserInfoByIdService(String id) {

        if(StringUtils.isEmpty(id)) {

            throw new ValidationException(
                    new ValidationError("'id' missing", "Provided id cannot be empty"),
                    ErrorResponseEnum.VALIDATION_ERROR);
        }

        userInfoRepository.deleteUserInfoById(id);
    }
}
