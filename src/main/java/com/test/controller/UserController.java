package com.test.controller;

import com.test.model.base.out.HttpResponse;
import com.test.model.base.out.PageVO;
import com.test.model.vo.in.UserListIn;
import com.test.model.vo.out.UsersListOut;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lu.feng
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/IUser/getUserList")
    public HttpResponse<PageVO<UsersListOut>> getUserList(@RequestBody UserListIn in) {
        return userService.getUserList(in);
    }

}
