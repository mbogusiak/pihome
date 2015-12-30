package com.marcin.pihome.integration.weather;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.marcin.pihome.facades.LedFacade;
import com.marcin.pihome.integration.pojo.CurrentWeather;
import com.marcin.pihome.weather.GetWeather;

public class ScheduledSender {
	@Autowired
	private LedFacade ledFacade;
	@Autowired
	private WeatherSender weatherSender;
	@Resource(name="mongoTemplate")
	private MongoOperations  mongoOperation;
	public void ask() throws InterruptedException {
		
		GetWeather getWeatherRequest = new GetWeather();
		getWeatherRequest.setCountryName("Poland");
		getWeatherRequest.setCityName("Wroclaw");
		CurrentWeather currentWeather = weatherSender.send(getWeatherRequest);
		Integer temperature= Integer.parseInt(currentWeather.getTemperature());
		if(temperature<1)
		{
			ledFacade.setErrorLed();

			}
		else if(temperature<6)
		{
			ledFacade.setWarningLed();
		}	
			
		else
		{
			ledFacade.setOkLed();
		}	
		System.out.println(currentWeather);
		mongoOperation.save(currentWeather);
		List<CurrentWeather> listUser = mongoOperation.findAll(CurrentWeather.class);
		System.out.println(" Number of probes = " + listUser.size());

	}
}
