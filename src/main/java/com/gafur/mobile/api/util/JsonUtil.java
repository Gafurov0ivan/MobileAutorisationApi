package com.gafur.mobile.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Преобразует объект в json строку
 *
 * @author igafurov
 * @since 07.12.2017
 */
@Service
public class JsonUtil {

    @Autowired
    ObjectMapper mapper;

    public String asJsonString(final Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
