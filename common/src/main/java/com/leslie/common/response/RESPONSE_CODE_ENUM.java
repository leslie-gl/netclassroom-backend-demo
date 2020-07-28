package com.leslie.common.response;


public enum RESPONSE_CODE_ENUM {
    /**
     * 成功
     */
    SUCCESS("成功"),

    /**
     * 失败
     */
    FAILURE("失败"),

    /**
     * 请求有误，一般是参数有误
     */
    BAD_REQUEST("请求有误"),
    /**
     * 服务暂不可用
     */
    FALLBACK("服务暂不可用"),

    /**
     * 服务出错相关
     */
    ERROR("服务出错"),

    /**
     * 无权限
     */
    NO_PERMISSION("无权限"),

    /**
     * 令牌丢失
     */
    JWT_LACK("令牌缺失"),

    /**
     * 令牌无效
     */
    JWT_INVALID("令牌无效"),

    /**
     * 令牌过期
     */
    JWT_EXPIRED("令牌过期"),

    /**
     * refresh令牌过期
     */
    JWT_REFRESH_EXPIRED("refresh令牌过期"),

    /**
     * 令牌被占，用于互踢
     */
    JWT_KICK("令牌被占");

    private final String description;

    RESPONSE_CODE_ENUM(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
