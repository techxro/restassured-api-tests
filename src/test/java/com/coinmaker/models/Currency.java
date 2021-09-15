package com.coinmaker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    @JsonProperty("status")
    private Status status;

    @JsonProperty("data")
    private List<CurrencyData> data;

    @JsonProperty("tags")
    private List<String> tags;
}