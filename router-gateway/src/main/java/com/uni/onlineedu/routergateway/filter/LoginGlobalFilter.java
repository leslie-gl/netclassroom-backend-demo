package com.uni.onlineedu.routergateway.filter;

import com.leslie.common.response.RESPONSE_CODE_ENUM;
import com.leslie.common.response.ResponseData;
import com.leslie.common.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

/**
 * @author Leslie
 * @date 2020/7/29
 */
@Component
public class LoginGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isBlank(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            // 默认httpStatus为 200
            //response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            ResponseData<Object> responseData = new ResponseData<>(RESPONSE_CODE_ENUM.JWT_LACK);
            DataBuffer wrap = response.bufferFactory().wrap(JsonUtils.toJsonString(responseData).getBytes(StandardCharsets.UTF_8));
            return response.writeWith(Mono.just(wrap));
        }
        return chain.filter(exchange);
    }
}
