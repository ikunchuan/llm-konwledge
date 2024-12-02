package com.llm.llm_knowledge.controller.admin;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.llm.llm_knowledge.entity.UserAdminInfo;
import com.llm.llm_knowledge.exception.UserException;
import com.llm.llm_knowledge.pojo.ResultEntity;
import com.llm.llm_knowledge.service.UserAdminInfoService;
import com.llm.llm_knowledge.vo.UserAdminInfoVO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : symao
 */

@RestController
@RequestMapping("/admin/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserAdminController {

    @Autowired
    private UserAdminInfoService userAdminInfoService;

    /**
     * 用户登录
     * @param userAdminInfoVO
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResultEntity login(@RequestBody UserAdminInfoVO userAdminInfoVO) throws Exception {
        // 如果用户同时没有输入用户名或密码，抛出异常
        if (null == userAdminInfoVO) {
            throw new UserException("参数不能为空");
        }
        // 如果用户没有输入密码，抛出异常
        if (StringUtils.isBlank(userAdminInfoVO.getUserName())) {
            throw new UserException("用户名不能为空");
        }
        // 如果用户没有输入密码，抛出异常
        if (StringUtils.isBlank(userAdminInfoVO.getPassword())) {
            throw new UserException("密码不能为空");
        }

        UserAdminInfo userAdminInfo = new UserAdminInfo();
        BeanUtils.copyProperties(userAdminInfoVO, userAdminInfo);
        UserAdminInfo userAdmin = userAdminInfoService.login(userAdminInfo);
        Integer userId = userAdmin.getUserId();
        // 执行登录
        StpUtil.login(userId, new SaLoginModel().setTimeout(60 * 60 * 24));
        return ResultEntity.success();
    }

    /**
     * 用户注销（退出登录）
     * @return
     */
    @PostMapping("/logout")
    public ResultEntity logout() {
        // 执行注销
        StpUtil.logout();
        return ResultEntity.success("注销成功");
    }

    /**
     * 用户注册
     * @param userAdminInfoVO
     * @return
     * @throws UserException
     */
    @PostMapping("/register")
    public ResultEntity register(@RequestBody UserAdminInfoVO userAdminInfoVO) throws UserException {
        if(null == userAdminInfoVO){
            throw new UserException("请输入用户名和密码");
        }
        if(null == userAdminInfoVO.getUserName()){
            throw new UserException("请输入用户名");
        }
        if(null == userAdminInfoVO.getPassword()){
            throw new UserException("请输入密码");
        }
        UserAdminInfo userAdminInfo = new UserAdminInfo();
        BeanUtils.copyProperties(userAdminInfoVO, userAdminInfo);
        Integer register = userAdminInfoService.register(userAdminInfo);
        if (1 == register.intValue()) {
            return ResultEntity.success("注册成功");
        } else {
            return ResultEntity.fail("注册失败");
        }
    }
}
