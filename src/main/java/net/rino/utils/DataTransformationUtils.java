package net.rino.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformationUtils {
    public   static String toJson(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            // format formater avec la methode writerWithDefaultPrettyPrinter()
            json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
            return json;
        } catch (JsonProcessingException e){
            return "{}";
        }

    }
}
