package com.test.model.vo.out;

import com.test.model.vo.UsersVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lu.feng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersListOut extends UsersVo {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

}