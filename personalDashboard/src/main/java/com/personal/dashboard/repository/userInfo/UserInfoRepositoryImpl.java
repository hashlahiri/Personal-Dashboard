package com.personal.dashboard.repository.userInfo;

import com.personal.dashboard.domain.enums.AuthServiceProvider;
import com.personal.dashboard.domain.enums.ErrorResponseEnum;
import com.personal.dashboard.domain.enums.ValidationErrorType;
import com.personal.dashboard.domain.userInfo.UserInfo;
import com.personal.dashboard.exception.ValidationError;
import com.personal.dashboard.exception.ValidationException;
import com.personal.dashboard.utils.Slug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;


public class UserInfoRepositoryImpl implements UserInfoRepositoryCustom {

    @Autowired
    private UserInfoRepository userInfoRepository;
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(UserInfoRepositoryImpl.class);

    @Override
    public List<UserInfo> getAllUsers() {

        return userInfoRepository.findAll();
    }

    @Override
    public Page<UserInfo> getAllUsersPage(Pageable page) {

        return userInfoRepository.findAll(page);
    }

    @Override
    public UserInfo insertUser(UserInfo userInfo) {

       userInfo = userInfo.toBuilder()
               .fullNameSlug(Slug.get(userInfo.getFullName()))
               .authServiceProvider(AuthServiceProvider.SPRING_BOOT)
               .deleted(Boolean.FALSE)
               .build();

        return userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getById(String id) {

        return userInfoRepository.findById(id).orElseThrow(() -> new ValidationException(
                new ValidationError("User Not Found by given 'id'", ValidationErrorType.INVALID_VALUE.getErrorType()),
                ErrorResponseEnum.VALIDATION_ERROR));
    }

    @Override
    public UserInfo getByUsername(String username) {

        UserInfo userInfoFetched = userInfoRepository.findByUsername(username);
        if(userInfoFetched == null) {
            throw new ValidationException(
                    new ValidationError("UserInfo Not Found", ValidationErrorType.INVALID_VALUE.getErrorType()),
                    ErrorResponseEnum.ENTITY_NOT_FOUND);
        }

        return userInfoFetched;
    }

    @Override
    public UserInfo updateUserInfo(UserInfo userInfo) {

        UserInfo userInfoFetched = userInfoRepository.getById(userInfo.getId());

        String email = (StringUtils.isEmpty(userInfo.getEmail())) ? userInfoFetched.getEmail() : userInfo.getEmail();
        String fullName = userInfoFetched.getFullName();
        String fullNameSlug = userInfoFetched.getFullNameSlug();
        if(!StringUtils.isEmpty(userInfo.getFullName())) {
            fullName = userInfo.getFullName();
            fullNameSlug = Slug.get(userInfo.getFullName());
        }

        userInfoFetched = userInfoFetched.toBuilder()
                .email(email)
                .fullName(fullName)
                .fullNameSlug(fullNameSlug)
                .modifiedBy(LocalDateTime.now().toString())
                .build();

        return userInfoRepository.save(userInfoFetched);
    }

    @Override
    public void deleteUserInfoById(String id) {

        userInfoRepository.deleteById(id);

    }

}
