package com.uni.onlineedu.userinfoapi;

import com.leslie.common.response.ResponseData;
import com.uni.onlineedu.userinfoapi.model.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Leslie
 * @date 2020/7/21
 */
public interface UserFeignApi {

    @GetMapping
    ResponseData<List<UserDTO>> queryAll();

    @GetMapping("{id}")
    ResponseData<UserDTO> queryById(@PathVariable("id") Long id);
}
