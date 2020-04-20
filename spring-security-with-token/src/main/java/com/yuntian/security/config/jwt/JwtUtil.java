package com.yuntian.security.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    @Resource
    private JwtProperties jwtProperties;


    public String createToken(String identityId, Map<String, Object> param) {
        return createToken(UUID.randomUUID().toString(), identityId, param);
    }

    public String createToken(String identityId) {
        return createToken(UUID.randomUUID().toString(), identityId, new HashMap<>());
    }

    /**
     * 根据身份ID标识，生成Token
     *
     * @param id         随机id
     * @param identityId 身份标识
     * @param param     关键用户信息-Payload非敏感信息
     * @return
     */
    public String createToken(String id, String identityId, Map<String, Object> param) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + jwtProperties.getExpire() * 1000);
        return Jwts.builder()
                .setId(id)
                .setSubject(identityId)
                .setClaims(param)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, generalKey())
                .compact();
    }


    /**
     * 由字符串生成加密key
     */
    public  SecretKey generalKey() {
        String stringKey = jwtProperties.getSecret();
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }


    /**
     * 获取 Token中的用户信息
     *
     * @param token
     * @return
     */
    public  Claims getTokenClaim(String token) {
        try {
            return Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Token 是否过期验证
     * @return
     */
    public  boolean isTokenExpired(String token) {
        return getTokenClaim(token).getExpiration().before(new Date());
    }

}
