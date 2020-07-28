package com.leslie.common.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.lang.Nullable;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MillisecondsToDateConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(String.class, Date.class));
    }

    @Override
    public Object convert(Object source, @Nullable TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (targetType.hasAnnotation(MvcMillToDate.class)) {
            return source != null && !"".equals(source) ? new Date(Long.parseLong(source.toString())) : null;
        } else {
            return source;
        }
    }


}
