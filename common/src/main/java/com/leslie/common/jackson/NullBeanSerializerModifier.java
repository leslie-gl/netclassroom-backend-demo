package com.leslie.common.jackson;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.leslie.common.jackson.serialize.NullArrayJsonSerializer;
import com.leslie.common.jackson.serialize.NullObjectJsonSerializer;
import com.leslie.common.jackson.serialize.NullStringJsonSerializer;

import java.util.List;


/**
 * @author kira
 * @date 2020/4/7 16:16
 */
public class NullBeanSerializerModifier extends BeanSerializerModifier {

    private static final JsonSerializer NULL_ARRAY_JSON_SERIALIZER = new NullArrayJsonSerializer();
    private static final JsonSerializer NULL_STRING_JSON_SERIALIZER = new NullStringJsonSerializer();
    private static final JsonSerializer NULL_OBJECT_JSON_SERIALIZER = new NullObjectJsonSerializer();

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List beanProperties) {
        for (Object beanProperty : beanProperties) {
            BeanPropertyWriter writer = (BeanPropertyWriter) beanProperty;
            JavaType javaType = writer.getType();

            if (javaType.isCollectionLikeType()) {
                //集合
                writer.assignNullSerializer(NullBeanSerializerModifier.NULL_ARRAY_JSON_SERIALIZER);
            } else if (javaType.isEnumType() || javaType.getRawClass() == String.class) {
                //String或enum
                writer.assignNullSerializer(NullBeanSerializerModifier.NULL_STRING_JSON_SERIALIZER);
            } else if (javaType.isJavaLangObject()) {
                //其他object
                writer.assignNullSerializer(NullBeanSerializerModifier.NULL_OBJECT_JSON_SERIALIZER);
            }
        }
        return beanProperties;
    }

}
