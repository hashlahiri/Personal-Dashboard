package com.personal.dashboard.controller;

import com.personal.dashboard.domain.userInfo.UserInfo;
import com.personal.dashboard.service.userInfo.UserInfoService;
import com.personal.dashboard.utils.APIEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = APIEndpoints.USERINFO_API_URL)
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/all/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserInfo>> getAllUsers() {

        List<UserInfo> result = userInfoService.getAllUsersService();

        return new ResponseEntity<List<UserInfo>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/all/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserInfo>> getAllUsersPage(Pageable page) {

        Page<UserInfo> result = userInfoService.getAllUsersPageService(page);

        return new ResponseEntity<Page<UserInfo>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> insertUser(@RequestBody(required = true) UserInfo user) {

        UserInfo result = userInfoService.insertUserService(user);

        return new ResponseEntity<UserInfo>(result, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> getById(@RequestParam(value = "id") String id) {

        UserInfo result = userInfoService.getByIdService(id);

        return new ResponseEntity<UserInfo>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> getByUsername(@RequestParam(value = "username", required = true) String username) {

        UserInfo result = userInfoService.getByUsernameService(username);

        return new ResponseEntity<UserInfo>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfo> updateUserInfo(@RequestBody(required = true) UserInfo userInfo) {

        UserInfo result = userInfoService.updateUserInfoService(userInfo);

        return new ResponseEntity<UserInfo>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@RequestParam(value = "id", required = true) String id) {

        userInfoService.deleteUserInfoByIdService(id);

        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }
}
