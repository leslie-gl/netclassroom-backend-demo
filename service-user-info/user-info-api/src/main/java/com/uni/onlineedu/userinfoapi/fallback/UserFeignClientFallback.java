package com.uni.onlineedu.userinfoapi.fallback;

import com.leslie.common.response.ResponseData;
import com.uni.onlineedu.userinfoapi.client.UserFeignClient;
import com.uni.onlineedu.userinfoapi.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Leslie
 * @date 2020/7/28
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public ResponseData<List<UserDTO>> queryAll() {
        return ResponseData.fallback();
    }

    @Override
    public ResponseData<UserDTO> queryById(Long id) {
        return ResponseData.fallback();
    }
}
