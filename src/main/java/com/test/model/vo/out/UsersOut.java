package com.test.model.vo.out;

import com.test.model.vo.UsersVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lu.feng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersOut extends UsersVo {

    /**
     * 角色名称
     */
    private String roleName;

}