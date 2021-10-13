package com.test.entity;

import com.test.entity.base.BaseBean;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author lu.feng
 */
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public class Users extends BaseBean implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -8079168749614391210L;

	/**
     * 用户id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户账户
     */
    @Column(name = "name")
    private String name;

    /**
     * 用户昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否删除
     */
    @Column(name = "is_del")
    private Boolean isDel;


    public enum ColumnEnum{
        id("id"),name("name"),nickName("nick_name"),email("email"),createTime("create_time"),updateTime("update_time"),isDel("is_del");

        ColumnEnum(String dbFieldName) {
            this.dbFieldName=dbFieldName;
        }

        public String getName() {
            return dbFieldName;
        }

        private String dbFieldName;
    }
}