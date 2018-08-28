package com.marcosbarbero.ifood.advanced.config.properties;

import lombok.Data;

@Data
public class OpenWeatherProperties {

    private String appId;
    private String baseUrl;
    private String units;

}
