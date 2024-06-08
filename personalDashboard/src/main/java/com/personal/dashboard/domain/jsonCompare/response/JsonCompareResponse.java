package com.personal.dashboard.domain.jsonCompare.response;

import lombok.*;

/**
 * Response of JsonCompare utility
 *
 * NOTE: Non collection POJO
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder(toBuilder = true)
public class JsonCompareResponse {

    private boolean exists;

}
