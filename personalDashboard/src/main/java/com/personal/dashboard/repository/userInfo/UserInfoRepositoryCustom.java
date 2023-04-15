package com.personal.dashboard.repository.userInfo;

import com.personal.dashboard.domain.userInfo.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserInfoRepositoryCustom {

    public List<UserInfo> getAllUsers();
    public Page<UserInfo> getAllUsersPage(Pageable page);
    public UserInfo insertUser(UserInfo user);
    public UserInfo getById(String id);
    public UserInfo getByUsername(String username);
    public UserInfo updateUserInfo(UserInfo userInfo);
    public void deleteUserInfoById(String id);
}
