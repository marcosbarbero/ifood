package com.marcosbarbero.ifood.advanced.service.weather.model;

import lombok.Data;

@Data
class Main {

    private Double temp;
    private Integer pressure;
    private Integer humidity;
    private Integer tempMin;
    private Integer tempMax;

}
