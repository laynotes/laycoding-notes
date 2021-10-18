package com.laycoding.common.enums;

import com.laycoding.common.constants.RedisConstants;

public enum RedisKeyEnum {
    USER_TOKEN(RedisConstants.USER_TOKEN_KEY, 3600L * 2);
    /**
     * key名称
     */
    private String key;
    /**
     * 过期时间
     */
    private Long time;

    RedisKeyEnum(String key, Long time) {
        this.key = key;
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
