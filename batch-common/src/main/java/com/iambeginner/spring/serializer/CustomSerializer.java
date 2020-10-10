package com.iambeginner.spring.serializer;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<Object> {

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
    Object encodingValue = configs.get(propertyName);
    if (encodingValue == null)
      encodingValue = configs.get("serializer.encoding");
  }


  @Override
  public byte[] serialize(String topic, Object data) {
    if (data == null)
      return null;
    else
      return SerializationUtils.serialize((Serializable) data);
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }


}


