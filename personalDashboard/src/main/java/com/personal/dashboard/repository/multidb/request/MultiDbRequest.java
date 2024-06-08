package com.personal.dashboard.repository.multidb.request;

import lombok.*;

/**
 * Multi DB request POJO
 *
 * NOTE: Non collection POJO
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder(toBuilder = true)
public class MultiDbRequest {

    private String name;

}
