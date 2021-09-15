package com.coinmaker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class Status {
    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("error_message")
    private String error_message;

    @JsonProperty("error_code")
    private String error_code;

    @JsonProperty("credit_count")
    private String credit_count;

}
