package com.uni.onlineedu.serviceconsumer.web.controller;

import com.leslie.common.response.ResponseData;
import com.uni.onlineedu.userinfoapi.client.UserFeignClient;
import com.uni.onlineedu.userinfoapi.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Leslie
 * @date 2020/7/28
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("user1")
    @SuppressWarnings("unchecked")
    public ResponseData<List<UserDTO>> queryUser1() {
        return restTemplate.getForObject("http://service-user-info/user", ResponseData.class);
    }

    @GetMapping("user2")
    public ResponseData<List<UserDTO>> queryUser2() {
        return userFeignClient.queryAll();
    }
}
