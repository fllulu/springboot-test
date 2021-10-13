package com.test.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lu.feng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UsersVo implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -8079168749614391210L;

	/**
     * 用户id
     */
    private Long id;

    /**
     * 用户账户
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean isDel;


}