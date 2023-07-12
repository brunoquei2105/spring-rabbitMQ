package com.example.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuOrder implements Serializable {
    private static final long serialVersionUID = -4048567712704967603L;

    @JsonProperty("orderIdentifier")
    private String orderIdentifier;

    @JsonProperty("orderId")
    private int orderId;

    @JsonProperty("orderList")
    private List<String> orderList;

    @JsonProperty("customerName")
    private String customerName;
}
