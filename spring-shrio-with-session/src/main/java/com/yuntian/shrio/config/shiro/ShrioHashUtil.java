package com.yuntian.shrio.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.SecureRandom;

/**
 * @author Administrator
 * @date 2020-04-22 22:31
 * @description
 */
public class ShrioHashUtil  {

    private final HashedCredentialsMatcher hashedCredentialsMatcher;

    public ShrioHashUtil(HashedCredentialsMatcher hashedCredentialsMatcher) {
        this.hashedCredentialsMatcher = hashedCredentialsMatcher;
    }

    public String hashPassWordStr(String credentials, String salt) {
        String pwdHashStr="";
        Hash hashPassWord=hashPassWord(credentials, salt);
        if (hashedCredentialsMatcher.isStoredCredentialsHexEncoded()) {
            pwdHashStr = Hex.encodeToString(hashPassWord.getBytes());
        } else {
            pwdHashStr = Base64.encodeBase64String(hashPassWord.getBytes());
        }
        return pwdHashStr;
    }


    private Hash hashPassWord(Object credentials, Object salt) {
        return new SimpleHash(hashedCredentialsMatcher.getHashAlgorithmName(), credentials, salt, hashedCredentialsMatcher.getHashIterations());
    }

    public boolean passwordsMatch(String pwd, String salt, String pwdHash) {
        AuthenticationToken token = new UsernamePasswordToken("", pwd);
        SaltedAuthenticationInfo info = new SimpleAuthenticationInfo("", pwdHash, ByteSource.Util.bytes(salt), "");
        return hashedCredentialsMatcher.doCredentialsMatch(token, info);
    }


    public String createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[15];
        random.nextBytes(bytes);
        return Base64.encodeBase64String(bytes);
    }

}
