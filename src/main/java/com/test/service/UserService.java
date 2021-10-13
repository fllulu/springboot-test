package com.test.service;

import com.test.model.base.out.HttpResponse;
import com.test.model.base.out.PageVO;
import com.test.model.vo.in.*;
import com.test.model.vo.out.UsersListOut;

/**
 * 用户接口
 *
 * @author lu.feng
 */
public interface UserService {


    /**
     * 用户列表
     *
     * @param in
     * @return
     */
    HttpResponse<PageVO<UsersListOut>> getUserList(UserListIn in);


}
