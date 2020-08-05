package com.uni.onlineedu.userinfo.web.controller;

import com.leslie.common.response.ResponseData;
import com.leslie.common.util.PojoConvertUtils;
import com.uni.onlineedu.userinfo.service.UserService;
import com.uni.onlineedu.userinfoapi.UserFeignApi;
import com.uni.onlineedu.userinfoapi.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Leslie
 * @date 2020/7/15
 */
@RestController
@RequestMapping("user")
public class UserController implements UserFeignApi {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @Override
    public ResponseData<List<UserDTO>> queryAll() {
        System.out.println("端口：" + port);
        return ResponseData.success(userService.findAll()
                .stream()
                .map(o -> PojoConvertUtils.convertObjectToAnother(o, UserDTO.class))
                .collect(Collectors.toList()));
    }

    @Override
    public ResponseData<UserDTO> queryById(Long id) {
        System.out.println("端口：" + port);
        return ResponseData.success(PojoConvertUtils.convertObjectToAnother(userService.getById(id), UserDTO.class));
    }
}
