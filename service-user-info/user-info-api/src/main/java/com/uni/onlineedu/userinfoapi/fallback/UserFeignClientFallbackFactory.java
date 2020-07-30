package com.uni.onlineedu.userinfoapi.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.leslie.common.response.ResponseData;
import com.uni.onlineedu.userinfoapi.client.UserFeignClient;
import com.uni.onlineedu.userinfoapi.model.UserDTO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Leslie
 * @date 2020/7/28
 */
@Slf4j
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        log.error("Exception in UserFeignClient:{}", throwable.getMessage(), throwable);

        return new UserFeignClient() {
            @Override
            public ResponseData<List<UserDTO>> queryAll() {
                return ResponseData.fallback();
            }

            @Override
            public ResponseData<UserDTO> queryById(Long id) {
                return ResponseData.fallback();
            }
        };
    }
}
