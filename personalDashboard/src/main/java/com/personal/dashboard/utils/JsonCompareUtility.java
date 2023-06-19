package com.personal.dashboard.utils;

import io.json.compare.CompareMode;
import io.json.compare.JSONCompare;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class JsonCompareUtility {

    private static final Logger LOG = LoggerFactory.getLogger(JsonCompareUtility.class);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Check if child json exists inside parent json
     *
     * @param parentJson - {@link String}
     * @param childJson - {@link String}
     * @return - {@link String}
     */
    public String jsonExistsWithinAnotherJson(String parentJson, String childJson) {

        try {
            // Expected Json is included in actual Json
            String expected = "{\"b\": \"val1\"}";
            String actual = "{\"a\":\"val2\", \"b\":\"val1\"}";
            JSONCompare.assertMatches(expected, actual); // assertion passes

            // JSON objects MUST have same sizes
            String expected1 = "{\"b\": \"val1\"}";
            String actual1 = "{\"a\":\"val2\", \"b\":\"val1\"}";
            JSONCompare.assertNotMatches(expected1, actual1, Set.of(CompareMode.JSON_OBJECT_NON_EXTENSIBLE)); // assertion passes
            JSONCompare.assertMatches(expected1, actual1, Set.of(CompareMode.JSON_OBJECT_NON_EXTENSIBLE)); // assertion fails


        } catch (Exception e) {

            LOG.error("Something went wrong inside 'jsonExistsWithinAnotherJson'");
            LOG.error("{} | {}", e.getMessage(), e.getClass());
        }

        return null;
    }




}
