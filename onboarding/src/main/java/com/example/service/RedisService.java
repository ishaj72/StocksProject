package com.example.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

   public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // SET with TTL
    public void set(String key, Object value, long ttlSeconds) {
        redisTemplate.opsForValue()
                     .set(key, value, Duration.ofSeconds(ttlSeconds));
    }

    // GET
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // DELETE
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // EXISTS
    public boolean exists(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
}
