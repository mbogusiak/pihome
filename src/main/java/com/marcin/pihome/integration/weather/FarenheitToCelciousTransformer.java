package com.marcin.pihome.integration.weather;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.messaging.Message;

import com.marcin.pihome.integration.pojo.CurrentWeather;

public class FarenheitToCelciousTransformer {

	public CurrentWeather transformFarenheitToCelcious(Message<CurrentWeather> payload)
	{
		
		CurrentWeather currentWeather = payload.getPayload();
		 String pattern = ".+ F \\(([-0-9]+)+ C\\)";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
	      Matcher m = r.matcher(currentWeather.getTemperature());
	      if (m.find( )) {
	    	  currentWeather.setTemperature(m.group(1));
	      }
		return currentWeather;
	}
}
