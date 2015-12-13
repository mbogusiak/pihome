package com.marcin.pihome.services;

import org.springframework.integration.annotation.MessagingGateway;

import com.marcin.pihome.integration.pojo.CurrentWeather;
import com.marcin.pihome.weather.GetWeather;
@MessagingGateway(name = "weatherSender", defaultRequestChannel = "weatherInputChannel", defaultReplyChannel ="outputWeatherChannel", defaultReplyTimeout=3000)
public interface WeatherSender {
	CurrentWeather send(GetWeather request);
}
