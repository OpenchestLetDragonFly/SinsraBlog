package com.sinsra.config;/*
 * ClassName: FastJsonRedisSerializer
 * Package: com.sinsra.config
 * @Create: 2024/4/25 17:21
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.parser.ParserConfig;
import java.nio.charset.Charset;


/**
 * FastJsonRedisSerializer 实现了 RedisSerializer 接口，用于将对象序列化成字节数组并存储在 Redis 中，
 * 或者从 Redis 中读取字节数组并反序列化为对象。
 * 默认使用 UTF-8 编码。
 * 这个序列化器基于 FastJson 库实现。
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    /** 默认字符集为 UTF-8 */
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /** 要序列化/反序列化的对象类型 */
    private Class<T> clazz;

    /** 在静态代码块中设置 FastJson 的全局配置，开启自动类型支持 */
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    /**
     * 构造函数，传入要序列化/反序列化的对象类型
     * @param clazz 要序列化/反序列化的对象类型
     */
    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    /**
     * 将对象序列化为字节数组
     * @param t 要序列化的对象
     * @return 序列化后的字节数组
     * @throws SerializationException 序列化异常
     */
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * 将字节数组反序列化为对象
     * @param bytes 要反序列化的字节数组
     * @return 反序列化后的对象
     * @throws SerializationException 反序列化异常
     */
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, clazz);
    }

    /**
     * 根据给定的类获取 JavaType 对象
     * @param clazz 给定的类
     * @return JavaType 对象
     */
    protected JavaType getJavaType(Class<?> clazz) {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}

