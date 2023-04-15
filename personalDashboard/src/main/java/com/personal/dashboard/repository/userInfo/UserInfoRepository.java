package com.personal.dashboard.repository.userInfo;

import com.personal.dashboard.domain.userInfo.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, String>, UserInfoRepositoryCustom {

    public UserInfo findByUsername(String username);

}
