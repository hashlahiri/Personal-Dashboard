package com.personal.dashboard.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class JsonCompareUtility {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOG = LoggerFactory.getLogger(JsonCompareUtility.class);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Check if json key is present inside actual json
     *
     * EXAMPLE: String json = "{ \"parent\": { \"child\": \"value\" } }";
     *
     * @param actualJson - {@link String}
     * @param parentString - {@link String}
     * @param keyString - {@link String}
     * @return - {@link String}
     */
    public String jsonKeyExistsWithinJson(String actualJson, String parentString, String keyString) {

        String result = "Json exists within another json: ";
        Boolean childPresent = false;
        try {
            // Parse the JSON string into a JsonNode object
            JsonNode jsonNode = objectMapper.readTree(actualJson);

            // Get the parent node
            JsonNode parentNode = jsonNode.get(parentString);

            // Check if the child node is present
            childPresent = parentNode.has(keyString);

        } catch (Exception e) {

            LOG.error("Something went wrong inside 'jsonKeyExistsWithinJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }

        return result + childPresent;
    }

}
