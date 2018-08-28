package com.marcosbarbero.ifood.advanced.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("ifood")
public class IFoodProperties {

    private OpenWeatherProperties openWeather;
    private SpotifyProperties spotify;

}
