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
     * @param root - {@link JsonNode}
     * @param parentKey - {@link String}
     * @param childKey - {@link String}
     * @return - {@link Boolean}
     */
    public boolean jsonKeyExistsWithinJson(JsonNode root, String parentKey, String childKey) {

        Boolean childPresent = false;
        try {
            // get the parentKey
            JsonNode parent = root.get(parentKey);

            // compare and return
            return parent != null && parent.has(childKey);

        } catch (Exception e) {

            LOG.error("Something went wrong inside 'jsonKeyExistsWithinJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }

        return childPresent;
    }

}
