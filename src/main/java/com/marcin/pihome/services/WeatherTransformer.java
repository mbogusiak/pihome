package com.marcin.pihome.services;


import org.springframework.messaging.Message;

import com.marcin.pihome.weather.GetWeatherResponse;

public class WeatherTransformer {

	public String transform(Message<GetWeatherResponse> payload) 
	{
		GetWeatherResponse r = payload.getPayload();
		return  r.getGetWeatherResult();
	}
}
