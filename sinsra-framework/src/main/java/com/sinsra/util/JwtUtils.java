/**
 * JwtUtils 提供了生成和解析 JWT（JSON Web Token）的工具方法。
 * JWT 是一种用于身份验证的令牌，它包含了一些声明（claims），被加密后用于在客户端和服务器之间传输信息。
 */
package com.sinsra.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtils {

    /** JWT 的有效期，默认为 72 小时 */
    public static final Long JWT_TTL = 72 * 60 * 60 * 1000L; // 72 小时
    /** 设置秘钥明文 */
    public static final String JWT_KEY = "sinsra";

    /**
     * 获取一个 UUID
     * @return UUID 字符串
     */
    public static String getUUID(){
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    /**
     * 创建 JWT
     * @param subject token 中要存放的数据（JSON 格式）
     * @return 生成的 JWT 字符串
     */
    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());// 设置过期时间
        return builder.compact();
    }

    /**
     * 创建 JWT
     * @param subject token 中要存放的数据（JSON 格式）
     * @param ttlMillis token 超时时间
     * @return 生成的 JWT 字符串
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());// 设置过期时间
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if(ttlMillis==null){
            ttlMillis= JwtUtils.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)              // 唯一的 ID
                .setSubject(subject)      // 主题，可以是 JSON 数据
                .setIssuer("SS")          // 签发者
                .setIssuedAt(now)         // 签发时间
                .signWith(signatureAlgorithm, secretKey) // 使用 HS256 对称加密算法签名，第二个参数为秘钥
                .setExpiration(expDate);
    }

    /**
     * 创建 token
     * @param id token 的唯一标识
     * @param subject token 中要存放的数据（JSON 格式）
     * @param ttlMillis token 超时时间
     * @return 生成的 JWT 字符串
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);// 设置过期时间
        return builder.compact();
    }

    /**
     * 创建加密后的秘钥 secretKey
     * @return 生成的秘钥
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtils.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析 JWT
     * @param jwt 要解析的 JWT 字符串
     * @return 解析后的 Claims 对象
     * @throws Exception 解析异常
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
