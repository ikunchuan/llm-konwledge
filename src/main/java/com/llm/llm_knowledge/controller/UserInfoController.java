package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.llm.llm_knowledge.entity.Community;
import com.llm.llm_knowledge.entity.Question;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("uis/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    // 查询所有用户（分页）
    /**
     * 管理员查看所有已注册的用户
     *
     * @return List<Community>
     */
    @GetMapping("ui")
    public IPage<UserInfo> allUser(@RequestParam(value = "pageNum") Integer pageNum,
                                   @RequestParam(value = "pageSize") Integer pageSize) {
        return userInfoService.allUser(pageNum, pageSize);
    }

    /**
     * 根据用户id查询用户
     *
     * @return Community
     */
    @GetMapping("ui/{userid}")
    public UserInfo userInfoById(@PathVariable Integer userid) {
        return userInfoService.userInfoById(userid);
    }


    /**
     * 根据用户性别和用户名字进行模糊查询
     *
     * @return List
     */
    @GetMapping("ui/search")
    public IPage<UserInfo> searchUsers(
            @RequestParam(required = false) Integer userSex,
            @RequestParam(required = false) String userName,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        return userInfoService.uiByCondi(userSex, userName, pageNum, pageSize);
    }


    /**
     * 新增一个社区,传入的是一个community实体
     *
     * @return Integer<Community>
     */
    @PostMapping("ui")
    public Integer addUserInfo(UserInfo userInfo) {
        return userInfoService.addUserInfo(userInfo);
    }


    /**
     * 根据cmnid删除社区
     *
     * @return Integer
     */
    @DeleteMapping("ui/{userid}")
    public Integer delUserInfo(@PathVariable Integer userid) {
        return userInfoService.delUserInfo(userid);
    }


    /**
     * 根据cmnid更新社区
     *
     * @return Integer
     */
    @PutMapping("ui")
    public Integer updateUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

}
