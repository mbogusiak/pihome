package com.marcin.pihome.core.services.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.marcin.pihome.core.services.LedService;
import com.marcin.pihome.pojo.PiLed;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.Pin;

@Component
public class DefaultLedService implements LedService {

	@Resource
	private GpioController gpioController = null;

	@Resource(name = "piLeds")
	private Map<String, PiLed> piLeds;

	@Resource(name = "piMap")
	private Map<Integer, Pin> pinsMap;

	private Logger log = Logger.getLogger(DefaultLedService.class.getName());
	
	public void turnLedOff(String name) {
		PiLed piLed = piLeds.get(name);
		tryTurnLedOff(piLed);
	}
	
	private void tryTurnLedOff(PiLed piLed){
		try
		{
			piLed.getGpio().low();
		}
		catch(Exception exc)
		{
			log.error("There was problem turning led off " + piLed.getName()+ " " + exc);
		}
	}
	
	public void turnLedOn(String name) {
		PiLed piLed = piLeds.get(name);
		tryTurnLedOn(piLed);
	}
	
	private void tryTurnLedOn(PiLed piLed)
	{
		try
		{
			piLed.getGpio().high();
		}
		catch(Exception exc)
		{
			log.error("There was problem turning led on " + piLed.getName() + " " + exc);
		}
	}
	
	public void blinkLed(String name) {
		PiLed piLed = piLeds.get(name);
		tryBlinkLed(piLed);
	}

	private void tryBlinkLed(PiLed piLed)
	{
		try
		{
			piLed.getGpio().blink(1000);
		}
		catch(Exception exc)
		{
			log.error("There was problem blinking led" + piLed.getName() + " " + exc);
		}
	}
	
	public void blinkLedOff(String name) {
		PiLed piLed = piLeds.get(name);
		tryBlinkLedOff(piLed);
	}
	
	private void tryBlinkLedOff(PiLed piLed)
	{
		try
		{
			piLed.getGpio().blink(0);
		}
		catch(Exception exc)
		{
			log.error("There was problem blinking led" + piLed.getName() + " " + exc);
		}
	}
	
	public Map<String, PiLed> getPiLeds() {
		return piLeds;
	}

	public void setPiLeds(Map<String, PiLed> piLeds) {
		this.piLeds = piLeds;
	}

	public Map<Integer, Pin> getPinsMap() {
		return pinsMap;
	}

	public void setPinsMap(Map<Integer, Pin> pinsMap) {
		this.pinsMap = pinsMap;
	}
}
