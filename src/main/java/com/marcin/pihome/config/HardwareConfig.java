package com.marcin.pihome.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.marcin.pihome.pojo.PiLed;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

@Configuration	
@ImportResource("classpath:integration.xml")
public class HardwareConfig {

	@Bean(name={"piMap"})
	public Map<Integer,Pin> getPiMap()
	{System.out.println("PI MAP");
		Map<Integer,Pin> pinsMap = new HashMap<Integer,Pin>();
		pinsMap.put(18, RaspiPin.GPIO_01);
		pinsMap.put(23, RaspiPin.GPIO_05);
		pinsMap.put(24, RaspiPin.GPIO_04);
		return pinsMap;
	}
	
	@Bean(name="leds")
	public Map<String, PiLed> createRedLed()
	{
		Map<String, PiLed> leds = new HashMap<String,PiLed>();
		PiLed redLed = new PiLed("red", 18);
		leds.put("red",redLed);
		PiLed greenLed = new PiLed("green", 23);
		leds.put("green",greenLed);
		PiLed orangeLed = new PiLed("orange", 34);
		leds.put("orange",orangeLed);

		return leds;
	}
	

}
