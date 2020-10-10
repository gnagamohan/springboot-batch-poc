package com.iambeginner.spring.serializer;

import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null)
            encodingValue = configs.get("deserializer.encoding");

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        if (data == null)
            return null;
        else
            return SerializationUtils.deserialize(data);
    }

    @Override
    public void close() {

    }

}
