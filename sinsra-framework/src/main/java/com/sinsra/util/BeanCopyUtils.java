package com.sinsra.util;/*
 * ClassName: BeanCopyUtils
 * Package: com.sinsra.util
 * @Create: 2024/4/24 15:55
 */

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils(){}

    //对单个对象进行封装
    public static <T> T copyBean(Object source, Class<T> clz){
        T result = null;
        try {
            result = clz.newInstance();
            BeanUtils.copyProperties(source,result);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    //对列表进行封装
    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clz){
        //不使用for循环，使用stream流进行转换
        return list.stream()
                .map(o -> copyBean(o, clz))
                //把结果转换成集合
                .collect(Collectors.toList());
    }

}
