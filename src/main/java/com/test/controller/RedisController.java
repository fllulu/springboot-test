package com.test.controller;

import com.test.entity.Users;
import com.test.model.vo.in.UserListIn;
import com.test.model.vo.out.UsersListOut;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fenglu
 * @date 2021/9/29 11:04 上午
 */
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private UserService userService;

    @GetMapping
    public void testRedis(){
        stringRedisTemplate.opsForValue().set("user","fl");
        String userName = stringRedisTemplate.opsForValue().get("user");
        System.out.println("名字："+userName);

        Users user = new Users();
        user.setName("zhangsan");
        user.setNickName("张三");

        redisTemplate.opsForValue().set("users", user);
        Users userInfo = (Users) redisTemplate.opsForValue().get("users");
        System.out.println("用户信息"+userInfo);
        System.out.println("用户昵称："+userInfo.getNickName());

        UserListIn in = new UserListIn();
        in.setPageIndex(1);
        in.setPageSize(10);
        List<UsersListOut> usersListOutList = userService.getUserList(in).getData().getRows();
        redisTemplate.opsForValue().set("usersList", usersListOutList);
        List<UsersListOut> userList = (List<UsersListOut>) redisTemplate.opsForValue().get("usersList");
        System.out.println("用户列表："+userList);
    }

}
