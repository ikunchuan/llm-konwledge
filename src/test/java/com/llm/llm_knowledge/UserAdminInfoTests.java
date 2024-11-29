package com.llm.llm_knowledge;

import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.service.UserAdminInfoService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : symao
 */
@SpringBootTest
public class UserAdminInfoTests {

    @Autowired
    private UserAdminInfoService userAdminInfoService;

    @Test
    public void addUser(){
        UserAdminInfo userAdminInfo = new UserAdminInfo();
        userAdminInfo.setUserName("admin");
        String md5 = DigestUtils.md5Hex("123456");
        userAdminInfo.setPassword(md5);
        userAdminInfoService.addUserAdminInfo(userAdminInfo);
    }

    @Test
    public void  login() throws UserException {
        UserAdminInfo userAdminInfo = new UserAdminInfo();
        userAdminInfo.setUserName("admin");
        String md5 = DigestUtils.md5Hex("1234561");
        userAdminInfo.setPassword(md5);
        UserAdminInfo result = userAdminInfoService.findUserAdminInfo(userAdminInfo);
        System.err.println(result.getUserName());
    }


}
