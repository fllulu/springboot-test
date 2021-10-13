package com.test.model.vo.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author lu.feng
 */
@Data
public class UserIn {

    @NotNull
    private Long userId;

}
