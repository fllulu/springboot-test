package com.test.model.vo.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author lu.feng
 */
@Data
public class DeleteUserIn {

    @NotNull
    private Long userId;

    /**
     * 当前登录人id
     */
    private Long loginUserId;

}
