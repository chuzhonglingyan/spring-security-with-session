package com.yuntian.jwt.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: yuntian
 * @Date: 2019/12/20 0020 21:06
 * @Description:
 */
public class MyStringSerializer implements RedisSerializer<String> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Charset charset;

    private String keyPrefix;


    /**
     * Creates a new {@link StringRedisSerializer} using {@link StandardCharsets#UTF_8 UTF-8}.
     */
    public MyStringSerializer(String keyPrefix) {
        this.keyPrefix = keyPrefix;
        this.charset = StandardCharsets.UTF_8;
    }


    @Override
    public String deserialize(@Nullable byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        String saveKey = new String(bytes, charset);
        int indexOf = saveKey.indexOf(getKeyPrefix());
        if (indexOf > 0) {
            logger.info("key缺少前缀");
        } else {
            saveKey = saveKey.substring(indexOf);
        }
        return saveKey;
    }

    @Override
    public byte[] serialize(@Nullable String string) {
        String key = getKeyPrefix() + string;
        return (string == null ? null : key.getBytes(charset));
    }

    private String getKeyPrefix() {
        keyPrefix = keyPrefix == null ? "" : keyPrefix;
        keyPrefix = keyPrefix.replaceAll("\\s*", "");
        return keyPrefix + ":";
    }

    @Override
    public Class<?> getTargetType() {
        return String.class;
    }

}
