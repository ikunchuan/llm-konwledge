package com.llm.llm_knowledge.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.llm.llm_knowledge.dto.DateUserCourseCountDTO;
import com.llm.llm_knowledge.dto.UserAgeDTO;
import com.llm.llm_knowledge.dto.UserCityDTO;
import com.llm.llm_knowledge.dto.UserCourseProgressDTO;
import com.llm.llm_knowledge.entity.UserInfo;
import com.llm.llm_knowledge.service.UserInfoService;
import com.llm.llm_knowledge.vo.UserInfoSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("uis/v1")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;
    //获取男女人数
    @GetMapping("ui/sex-distribution")
    public List<Map<String, Object>> getUserSexDistribution() {
        return userInfoService.getUserSexDistribution();
    }
    //获取用户总数
    @GetMapping("ui/user-total-count")
    public ResponseEntity<Integer> getUserTotalCount() {
        int total = userInfoService.getUserTotalCount();
        return ResponseEntity.ok(total);
    }


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
     * 根据用户性别和用户名字进行模糊查询  这里显示的是没有被冻结的用户
     *
     * @return PageInfo
     */
    @PostMapping("ui/search")
    public PageInfo<UserInfo> searchUsers(
            @RequestBody UserInfoSearch userInfoSearch,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        return userInfoService.uiByCondi(userInfoSearch, pageNum, pageSize);
    }
    
    
    /**
     * 根据用户性别和用户名字进行模糊查询  这里显示的是被冻结的用户
     *
     * @return PageInfo
     */
    @PostMapping("ui/search2")
    public PageInfo<UserInfo> searchUsers2(
            @RequestBody UserInfoSearch userInfoSearch,
            @RequestParam(value = "pageNum") Integer pageNum,
            @RequestParam(value = "pageSize") Integer pageSize) {
        return userInfoService.uiByCondi2(userInfoSearch, pageNum, pageSize);
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
     * 更新用户
     *
     * @return Integer
     */
    @PutMapping("ui")
    public Integer updateUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

    //多表联查
    @GetMapping("ui/watch")
    public List<UserCourseProgressDTO> progressDTOS(){
        return userInfoService.progressDTO();
    }

    //获取用户观看视频总数
    @GetMapping("ui/countCourseAll")
    public List<Map<String, Object>> getCompletedCoursesCount(){
        return userInfoService.getCompletedCoursesCount();
    }
    
    
    //呈现每个城市里面的用户总数
    @GetMapping("ui/cityuserall")
    public List<UserCityDTO> getCityUserCount(){
        return userInfoService.getCityUserCount();
    }
    
    //呈现每个年龄的用户人数
    @GetMapping("ui/userageall")
    public List<UserAgeDTO> getAgeUserCount(){
        return userInfoService.getAgeUserCount();
    }
    
    //selectDateCourseAll查看每天的每个课程有多少人看了
    @GetMapping("ui/dateusercount")
    public List<DateUserCourseCountDTO> selectDateCourseAll(){
        return userInfoService.selectDateCourseAll();
    }
}
