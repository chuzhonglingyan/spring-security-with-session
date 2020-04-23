package com.yuntian.shrio.config.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisCache<V> implements Cache<String, V> {

    private final RedisTemplate<String, V> redisTemplate;
    private final String keyPrefix;

    public RedisCache(RedisTemplate<String, V> redisTemplate, String keyPrefix) {
        this.redisTemplate = redisTemplate;
        this.keyPrefix = keyPrefix;
    }

    public ValueOperations<String, V> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    private String getKey(String key) {
        return keyPrefix + ":" + key;
    }

    @Override
    public V get(String key) throws CacheException {
        return getValueOperations().get(getKey(key));
    }

    @Override
    public V put(String key, V v) throws CacheException {
        getValueOperations().set(getKey(key), v);
        return v;
    }

    @Override
    public V remove(String key) throws CacheException {
        V v = getValueOperations().get(getKey(key));
        redisTemplate.delete(getKey(key));
        return v;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<String> keys() {
        Set<String> stringSet = redisTemplate.keys(keyPrefix + "*");
        if (stringSet == null) {
            stringSet = new HashSet<>();
        }
        return stringSet;
    }

    @Override
    public Collection<V> values() {
        Set<String> keys = keys();
        return getValueOperations().multiGet(keys);
    }
}
