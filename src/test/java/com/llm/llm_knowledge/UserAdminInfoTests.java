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


}
