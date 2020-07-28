package com.leslie.common.jackson.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Leslie
 * @date 2020/6/9
 */
public class NullByteJsonSerialize extends JsonSerializer<byte[]> {

    @Override
    public void serialize(byte[] bytes, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (bytes == null || bytes.length == 0) {
            jsonGenerator.writeString("");
        } else {
            jsonGenerator.writeString(new String(bytes, Charset.defaultCharset()));
        }
    }
}