package com.leslie.common.jackson.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author 15893
 */
public class NullByteJsonDeserialize extends JsonDeserializer<byte[]> {

    @Override
    public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        String stringValue = p.getText();
        if (stringValue == null || "".equals(stringValue)) {
            return null;
        }

        return stringValue.getBytes();
    }

}
