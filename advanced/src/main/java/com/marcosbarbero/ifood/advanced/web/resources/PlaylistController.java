package com.marcosbarbero.ifood.advanced.web.resources;

import com.marcosbarbero.ifood.advanced.service.weather.WeatherService;
import com.marcosbarbero.ifood.advanced.service.weather.model.OpenWeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final WeatherService weatherService;

    @GetMapping
    public OpenWeatherResponse get(@RequestParam String cityName) {
        return weatherService.get(cityName, null, null);
    }

}
