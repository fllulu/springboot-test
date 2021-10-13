package com.test.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.test.dao.UserDao;
import com.test.model.base.out.HttpResponse;
import com.test.model.base.out.PageVO;
import com.test.model.vo.in.UserListIn;
import com.test.model.vo.out.UsersListOut;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author lu.feng
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 获取用户列表
     * @param in
     * @return
     */
    @Override
    public HttpResponse<PageVO<UsersListOut>> getUserList(UserListIn in) {
        //分页
        PageHelper.startPage(in.getPageIndex(), in.getPageSize());
        List<UsersListOut> listOuts = userDao.getUserList(in);

        Page page = (Page) listOuts;
        return HttpResponse.success(PageVO.getPageVo(page.getTotal(), page.getPages(), listOuts));
    }

}
