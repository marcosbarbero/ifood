package com.marcosbarbero.ifood.advanced.service.weather;

import com.marcosbarbero.ifood.advanced.service.weather.model.OpenWeatherResponse;

public interface WeatherService {

    OpenWeatherResponse get(String cityName, Double lat, Double lon);

}
