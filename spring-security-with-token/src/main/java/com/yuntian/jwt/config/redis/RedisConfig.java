package com.yuntian.jwt.config.redis;

import com.alibaba.fastjson.parser.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.lang.NonNull;

import java.time.Duration;

/**
 * @author Administrator
 * @Auther: yuntian
 * @Date: 2019/8/17 0017 22:14
 * @Description:
 */
@Slf4j
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {


    @Bean
    RedisRemoteProperties redisRemoteProperties() {
        return new RedisRemoteProperties();
    }


    @Bean(name = "redisTemplate")
    public <V> RedisTemplate<String, V> redisTemplate(RedisConnectionFactory redisConnectionFactory, RedisRemoteProperties redisRemoteProperties) {
        RedisTemplate<String, V> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        FastJsonRedisSerializer<V> fastJsonRedisSerializer = new FastJsonRedisSerializer<>();
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        redisTemplate.setValueSerializer(fastJsonRedisSerializer);
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new MyStringSerializer(redisRemoteProperties.getKeyPrefix()));
        redisTemplate.setHashKeySerializer(new MyStringSerializer(redisRemoteProperties.getKeyPrefix()));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


    /**
     * 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory, RedisRemoteProperties redisRemoteProperties) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig().entryTtl(
                Duration.ofMinutes(30)).serializeKeysWith(RedisSerializationContext.SerializationPair
                .fromSerializer(new MyStringSerializer(redisRemoteProperties.getKeyPrefix()))).serializeValuesWith(RedisSerializationContext
                .SerializationPair.fromSerializer(new FastJsonRedisSerializer<>())).disableCachingNullValues();
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, config);
    }

    @Bean
    RedisManage redisManage() {
        return new RedisManage();
    }



    @Override
    @Bean
    public CacheErrorHandler errorHandler() {
        // 异常处理，当Redis发生异常时，打印日志，但是程序正常走
        log.info("初始化 -> [{}]", "Redis CacheErrorHandler");
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(@NonNull RuntimeException e, @NonNull Cache cache, @NonNull Object key) {
                log.error("Redis occur handleCacheGetError：key -> [{}]", key, e);
            }

            @Override
            public void handleCachePutError(@NonNull RuntimeException e, @NonNull Cache cache, @NonNull Object key, Object value) {
                log.error("Redis occur handleCachePutError：key -> [{}]；value -> [{}]", key, value, e);
            }

            @Override
            public void handleCacheEvictError(@NonNull RuntimeException e, @NonNull Cache cache, @NonNull Object key) {
                log.error("Redis occur handleCacheEvictError：key -> [{}]", key, e);
            }

            @Override
            public void handleCacheClearError(@NonNull RuntimeException e, @NonNull Cache cache) {
                log.error("Redis occur handleCacheClearError：", e);
            }
        };
    }


    /**
     * 配置spring boot的注解，进行方法级别的缓存
     * 使用：进行分割，可以很多显示出层级关系
     *
     * @return
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(":");
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(":").append(String.valueOf(obj));
            }
            String rsToUse = String.valueOf(sb);
            log.info("自动生成Redis Key -> [{}]", rsToUse);
            return rsToUse;
        };
    }


}
