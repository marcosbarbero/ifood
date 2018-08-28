package com.marcosbarbero.ifood.advanced.service.weather.model;

import lombok.Data;

@Data
class Weather {

    private Long id;
    private String main;
    private String description;
    private String icon;

}
