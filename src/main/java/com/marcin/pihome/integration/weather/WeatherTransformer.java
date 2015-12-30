package com.marcin.pihome.integration.weather;


import org.springframework.messaging.Message;

import com.marcin.pihome.weather.GetWeatherResponse;

public class WeatherTransformer {

	public String transform(Message<GetWeatherResponse> payload) 
	{
		GetWeatherResponse response = payload.getPayload();
		return  response.getGetWeatherResult();
	}
}
