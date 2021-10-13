package com.test.model.vo.in;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author lu.feng
 */
@Data
public class UpdateUserIn {

    @NotNull
    private Long id;

    /**
     * 昵称
     */
    @Length(min = 1)
    @NotBlank
    private String nickName;

    /**
     * 角色id
     */
    @NotNull
    private Long roleId;

}
