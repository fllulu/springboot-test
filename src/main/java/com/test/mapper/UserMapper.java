package com.test.mapper;

import com.test.entity.Users;
import com.test.mapper.base.BaseMapper;
import com.test.model.vo.in.UserListIn;
import com.test.model.vo.out.UsersListOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lu.feng
 */
@Mapper
public interface UserMapper extends BaseMapper<Users> {

    /**
     * 根据用户名或者昵称查找用户
     * @param name
     * @return
     */
    @Select(" SELECT id, `name`, nick_name nickName, email  " +
            "FROM users  " +
            "WHERE is_del = 0  " +
            "AND ( `name` LIKE \"%\"#{name}\"%\" OR nick_name LIKE \"%\"#{name}\"%\")  ")
    List<Users> getUsersByNameOrNickName(@Param("name") String name);

    /**
     * 获取用户列表
     * @param in
     * @return
     */
    @Select(" <script> " +
            " SELECT " +
            "   u.id," +
            "   u.`name`," +
            "   u.nick_name nickName," +
            "   u.email," +
            "   u.create_time createTime, " +
            "   u.update_time updateTime, " +
            "   u.is_del isDel, " +
            "   r.id roleId, " +
            "   r.role_name roleName " +
            " from users u " +
            " LEFT JOIN user_role ur on u.id = ur.user_id " +
            " LEFT JOIN role r on r.id = ur.role_id " +
            " WHERE u.is_del = 0  " +
            "   AND ur.is_del = 0" +
            " <if test=\"query.roleId != null \"> " +
            "   AND r.id =  ${query.roleId} " +
            " </if> " +
            " <if test=\"query.name != null and  query.name != ''  \"> " +
            "       AND (u.`name` LIKE \"%\"#{query.name}\"%\" OR nick_name LIKE \"%\"#{query.name}\"%\") "+
            " </if> "+
            " ORDER BY u.create_time DESC" +
            " </script>"
    )
    List<UsersListOut> getUserList(@Param("query") UserListIn in);

}