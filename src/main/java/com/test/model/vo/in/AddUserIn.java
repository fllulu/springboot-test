package com.test.model.vo.in;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author lu.feng
 */
@Data
public class AddUserIn {

    @Length(min = 1)
    @NotBlank
    private String name;

    @Length(min = 1)
    @NotBlank
    private String nickName;

    @NotNull
    private Long roleId;

    private String email;

}
