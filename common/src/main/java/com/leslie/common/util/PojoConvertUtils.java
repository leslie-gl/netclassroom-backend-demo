package com.leslie.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class PojoConvertUtils {

    public static <T> T convertObjectToAnother(Object source, Class<T> target) {
        T another = null;
        if (source != null) {
            try {
                another = target.newInstance();
                BeanUtils.copyProperties(source, another);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                log.error("类转换失败", e);
            }
        }
        return another;
    }

}
