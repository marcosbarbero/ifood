package com.marcosbarbero.ifood.advanced.config;

import com.marcosbarbero.ifood.advanced.config.properties.IFoodProperties;
import com.marcosbarbero.ifood.advanced.config.properties.OpenWeatherProperties;
import com.marcosbarbero.ifood.advanced.config.properties.SpotifyProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.HashMap;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private static final String DEFAULT_VALUE = "";

    private final IFoodProperties iFoodProperties;

    @Bean
    public RestTemplate openWeatherRestTemplate() {
        OpenWeatherProperties openWeather = iFoodProperties.getOpenWeather();
        HashMap<String, Object> uriVariables = new HashMap<String, Object>() {{
            put("appid", openWeather.getAppId());
            put("units", openWeather.getUnits());
            put("q", DEFAULT_VALUE);
            put("lat", DEFAULT_VALUE);
            put("lon", DEFAULT_VALUE);
        }};

        DefaultUriBuilderFactory builder = new DefaultUriBuilderFactory(openWeather.getBaseUrl());
        builder.setDefaultUriVariables(uriVariables);

        return new RestTemplateBuilder().uriTemplateHandler(builder).build();
    }

    @Bean
    public RestTemplate spotifyRestTemplate() {
        SpotifyProperties spotify = iFoodProperties.getSpotify();
        HashMap<String, Object> uriVariables = new HashMap<String, Object>() {{
            put("clientId", spotify.getClientId());
        }};

        DefaultUriBuilderFactory builder = new DefaultUriBuilderFactory(spotify.getBaseUrl());
        builder.setDefaultUriVariables(uriVariables);

        return new RestTemplateBuilder().uriTemplateHandler(builder).build();
    }
}
