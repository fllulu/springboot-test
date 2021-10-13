package com.test.model.vo.in;

import com.test.model.base.in.QueryPage;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author lu.feng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserListIn extends QueryPage {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户名
     */
    private String name;

}
