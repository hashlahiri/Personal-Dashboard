package com.personal.dashboard.domain.jsonCompare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Json compare request pojo
 *
 * NOTE: Non collection POJO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class JsonCompareRequest {

    private String jsonCompare1;

    private String jsonCompare2;

    private String jsonCompare3;

}
