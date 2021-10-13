package com.test.dao;

import com.test.dao.base.BaseDao;
import com.test.entity.Users;
import com.test.mapper.UserMapper;
import com.test.model.vo.in.UserListIn;
import com.test.model.vo.out.UsersListOut;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lu.feng
 */
@Service
public class UserDao extends BaseDao<Users> {

    @Autowired
    private UserMapper usersMapper;

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    public Users getUser(Long userId) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo(Users.ColumnEnum.id.name(), userId);
        return usersMapper.selectOneByExample(example);
    }

    /**
     * 根据用户id和名称查询用户信息
     * @param userId
     * @param name
     * @return
     */
    public Users getUser(Long userId, String name) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        if (userId != null && userId > 0) {
            criteria.andEqualTo(Users.ColumnEnum.id.name(), userId);
        }
        if (StringUtils.isNotBlank(name)) {
            criteria.andEqualTo(Users.ColumnEnum.name.name(), name);
        }
        criteria.andEqualTo(Users.ColumnEnum.isDel.name(), false);
        return usersMapper.selectOneByExample(example);
    }

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    public Users getUserByName(String userName) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo(Users.ColumnEnum.name.name(), userName)
                .andEqualTo(Users.ColumnEnum.isDel.name(), false);
        return usersMapper.selectOneByExample(example);
    }

    /**
     * 根据用户名和邮箱查询用户
     * @param userName
     * @param email
     * @return
     */
    public Users getUserByNameAndEmail(String userName, String email) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo(Users.ColumnEnum.name.name(), userName)
                .andEqualTo(Users.ColumnEnum.email.name(), email)
                .andEqualTo(Users.ColumnEnum.isDel.name(), false);
        return usersMapper.selectOneByExample(example);
    }

    /**
     * 根据用户名或者昵称查询用户
     * @param name
     * @return
     */
    public List<Users> getUsersByNameOrNickName(String name) {
        return usersMapper.getUsersByNameOrNickName(name);
    }

    /**
     * 获取用户列表
     * @param in
     * @return
     */
    public List<UsersListOut> getUserList(UserListIn in) {
        return usersMapper.getUserList(in);
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    public boolean addUser(Users user) {
        return insertSelective(user) > 0;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(Users user){
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo(Users.ColumnEnum.id.name(), user.getId());
        return updateByExampleSelective(user, example) > 0;
    }

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    public boolean deleteUser(Long userId) {
        Users user = new Users();
        user.setIsDel(true);
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo(Users.ColumnEnum.id.name(), userId);
        return updateByExampleSelective(user, example) > 0;
    }
}