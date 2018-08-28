package com.marcosbarbero.ifood.advanced.service.weather;

import com.marcosbarbero.ifood.advanced.config.properties.IFoodProperties;
import com.marcosbarbero.ifood.advanced.config.properties.OpenWeatherProperties;
import com.marcosbarbero.ifood.advanced.service.weather.model.OpenWeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isNotBlank;

@Service
public class DefaultWeatherService implements WeatherService {

    private final RestTemplate openWeatherRestTemplate;
    private final OpenWeatherProperties openWeatherProperties;

    public DefaultWeatherService(RestTemplate openWeatherRestTemplate, IFoodProperties iFoodProperties) {
        this.openWeatherRestTemplate = openWeatherRestTemplate;
        this.openWeatherProperties = iFoodProperties.getOpenWeather();
    }

    @Override
    public OpenWeatherResponse get(String cityName, Double lat, Double lon) {
        if (isNotBlank(cityName)) {
            return get(cityName);
        }
        return get(lat, lon);
    }

    private OpenWeatherResponse get(String cityName) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("q", cityName);

        ResponseEntity<OpenWeatherResponse> response = openWeatherRestTemplate.getForEntity(openWeatherProperties.getBaseUrl(),
                OpenWeatherResponse.class, uriVariables);

        return response.getBody();
    }

    private OpenWeatherResponse get(Double lat, Double lon) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("lat", lat);
        uriVariables.put("lon", lon);

        ResponseEntity<OpenWeatherResponse> response = openWeatherRestTemplate.getForEntity(openWeatherProperties.getBaseUrl(),
                OpenWeatherResponse.class, uriVariables);
        return response.getBody();
    }

}
