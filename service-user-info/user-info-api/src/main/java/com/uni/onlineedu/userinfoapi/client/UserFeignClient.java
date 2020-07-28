package com.uni.onlineedu.userinfoapi.client;

import com.uni.onlineedu.userinfoapi.UserFeignApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Leslie
 * @date 2020/7/28
 */
@FeignClient(name = "service-user-info", path = "user")
public interface UserFeignClient extends UserFeignApi {
}
