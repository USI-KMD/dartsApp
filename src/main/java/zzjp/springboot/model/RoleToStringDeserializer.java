package zzjp.springboot.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.io.IOException;

/**
 * Created by lukasz on 6/7/17.
 */
public class RoleToStringDeserializer extends JsonDeserializer {
    @Override
    public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        return null;
    }
}
