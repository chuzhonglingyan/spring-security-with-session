package com.yuntian.shrio.config.shiro;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


public class ReidsCachesMager<V> extends AbstractCacheManager {

    private final RedisTemplate<String, V> shrioRedisTemplate;

    public ReidsCachesMager(RedisConnectionFactory factory) {
        this.shrioRedisTemplate = new RedisTemplate<>();
        this.shrioRedisTemplate.setConnectionFactory(factory);
        this.shrioRedisTemplate.setKeySerializer(new StringRedisSerializer());
        this.shrioRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        this.shrioRedisTemplate.setValueSerializer(getValueSerializer());
        this.shrioRedisTemplate.setHashValueSerializer(getValueSerializer());
        this.shrioRedisTemplate.afterPropertiesSet();
    }


    @Override
    protected Cache<String, V> createCache(String name) throws CacheException {
        return new RedisCache<>(this.shrioRedisTemplate , name);
    }

    @Override
    public void destroy() {

    }

    private RedisSerializer<Object> getValueSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }


}
