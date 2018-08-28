package com.marcosbarbero.ifood.advanced.service.weather.model;

import lombok.Data;

import java.util.List;

import static java.util.Collections.emptyList;

@Data
public class OpenWeatherResponse {

    private Coord coord;
    private List<Weather> weather = emptyList();
    private String base;
    private Main main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Long id;
    private String name;
    private Long cod;

}
