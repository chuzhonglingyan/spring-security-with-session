package com.yuntian.security.config.security;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2020-04-19 23:15
 * @description
 */
public class RedisTokenRepositoryImpl implements PersistentTokenRepository {

    private final static String USERNAME_KEY = "spring:security:rememberMe:USERNAME_KEY:";
    private final static String SERIES_KEY = "spring:security:rememberMe:SERIES_KEY:";
    @Resource
    private RedisTemplate redisTemplate;

    private long exTime = 86400;


    public RedisTokenRepositoryImpl(long exTime) {
        this.exTime = exTime;
    }

    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        String series = persistentRememberMeToken.getSeries();
        String seriesKey = generateKey(series, SERIES_KEY);
        String usernameKey = generateKey(persistentRememberMeToken.getUsername(), USERNAME_KEY);
        //用户只要采用账户密码重新登录，那么为了安全就有必要清除之前的token信息。deleteIfPresent方法通过
        //username查找到用户对应的series，然后删除旧的token信息。
        deleteIfPresent(usernameKey);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", persistentRememberMeToken.getUsername());
        hashMap.put("token", persistentRememberMeToken.getTokenValue());
        hashMap.put("date", String.valueOf(persistentRememberMeToken.getDate().getTime()));
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(seriesKey, hashMap);
        redisTemplate.expire(seriesKey, exTime, TimeUnit.SECONDS);

        redisTemplate.opsForValue().set(usernameKey, series);
        redisTemplate.expire(usernameKey, exTime, TimeUnit.SECONDS);
    }

    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        String key = generateKey(series, SERIES_KEY);
        if (redisTemplate.hasKey(key)) {
            redisTemplate.opsForHash().put(key, "token", tokenValue);
            redisTemplate.opsForHash().put(key, "date", String.valueOf(lastUsed.getTime()));
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        String key = generateKey(seriesId, SERIES_KEY);
        Collection<String> hashKeys = new ArrayList<>();
        hashKeys.add("username");
        hashKeys.add("token");
        hashKeys.add("date");
        List<String> hashValues = redisTemplate.opsForHash().multiGet(key, hashKeys);
        String username = hashValues.get(0);
        String tokenValue = hashValues.get(1);
        String date = hashValues.get(2);
        if (null == username || null == tokenValue || null == date) {
            return null;
        }
        long timestamp = Long.parseLong(date);
        Date time = new Date(timestamp);
        return new PersistentRememberMeToken(username, seriesId, tokenValue, time);
    }

    @Override
    public void removeUserTokens(String username) {
        //rememberMeService实现类中调用这个方法传入的参数是username，因此我们必须通过username查找到
        //对应的series，然后再通过series查找到对应的token信息再删除。
        String key = generateKey(username, USERNAME_KEY);
        deleteIfPresent(key);
    }

    /**
     * 删除token时应该同时删除token信息，以及保存了对应的username与series对照数据。
     *
     * @param key
     */
    private void deleteIfPresent(String key) {
        if (redisTemplate.hasKey(key)) {
            String series = generateKey((String) redisTemplate.opsForValue().get(key), SERIES_KEY);
            if (series != null && redisTemplate.hasKey(series)) {
                redisTemplate.delete(series);
                redisTemplate.delete(key);
            }
        }
    }

    private String generateKey(String key, String prefix) {
        return prefix + key;
    }
}
