package com.marcin.pihome.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.marcin.pihome.drivers.LedDriver;
import com.marcin.pihome.integration.pojo.CurrentWeather;
import com.marcin.pihome.weather.GetWeather;

public class ScheduledSender {
	@Autowired
	private LedDriver ledriver;
	@Autowired
	private WeatherSender sender;

	public void ask() throws InterruptedException {
//		ledriver.turnGreenLedOn();
		GetWeather getWeatherRequest = new GetWeather();
		getWeatherRequest.setCountryName("Poland");
		getWeatherRequest.setCityName("Wroclaw");
		CurrentWeather r = sender.send(getWeatherRequest);
//		ledriver.turnGreenLedOff();
		System.out.println(r.getTemperature());
	}
}
