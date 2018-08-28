package com.marcosbarbero.ifood.advanced.service.weather.model;

import lombok.Data;

@Data
class Sys {

    private Integer type;
    private Double message;
    private String country;
    private Long sunrise;
    private Long sunset;

}
