package com.uni.onlineedu.userinfoapi.client;

import com.uni.onlineedu.userinfoapi.UserFeignApi;
import com.uni.onlineedu.userinfoapi.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Leslie
 * @date 2020/7/28
 */
@FeignClient(name = "service-user-info", path = "user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient extends UserFeignApi {
}
