package com.personal.dashboard.domain.jsonCompare.request;

import lombok.*;

/**
 * Json compare request pojo
 *
 * NOTE: Non collection POJO
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder(toBuilder = true)
public class JsonCompareRequest {

    private String payload;

    private String parentKey;

    private String childKey;

}
