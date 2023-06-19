package com.personal.dashboard.domain.jsonCompare;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class JsonCompareRequest {

    private String jsonCompare1;
    private String jsonCompare2;
}
