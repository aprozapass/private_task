package com.model.redis;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("CsvFileRedis")
public class RedisCsvFile implements Serializable {
    private String id;

    public RedisCsvFile() {
    }

    public RedisCsvFile(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
