package com.uni.onlineedu.userinfoapi.fallback;

import com.uni.onlineedu.userinfoapi.client.UserFeignClient;
import feign.hystrix.FallbackFactory;

/**
 * @author Leslie
 * @date 2020/7/28
 */
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return null;
    }
}
