package com.uni.onlineedu.userinfo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 手机号
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 办公电话
     */
    @Column(name = "office_phone")
    private String officePhone;

    /**
     * 职务
     */
    @Column(name = "job")
    private String job;

    /**
     * 头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 刷新token
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * 用户的状态
     */
    @Column(name = "is_active")
    private Boolean active;

}
