package com.uni.onlineedu.userinfoapi.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Leslie
 * @date 2020/7/21
 */
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String realName;

    private String officePhone;

    private String job;

    private String avatarUrl;

    private String refreshToken;

    private Boolean active;
}
