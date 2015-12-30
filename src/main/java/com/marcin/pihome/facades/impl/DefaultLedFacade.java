package com.marcin.pihome.facades.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.marcin.pihome.core.services.impl.DefaultLedService;
import com.marcin.pihome.facades.LedFacade;
import com.marcin.pihome.pojo.PiLed;

@Component
public class DefaultLedFacade implements LedFacade {

	@Autowired
	private DefaultLedService ledDriver;
	@Resource(name="piLeds")
	private Map<String, PiLed> ledsMap;
	@Override
	public void setErrorLed() throws InterruptedException {
		
		ledDriver.blinkLed("red");
		ledDriver.blinkLedOff("green");
		ledDriver.blinkLedOff("orange");
		ledDriver.turnLedOff("green");
		ledDriver.turnLedOff("orange");
	}

	@Override
	public void setOkLed() throws InterruptedException{
		ledDriver.blinkLed("green");
		ledDriver.blinkLedOff("red");
		ledDriver.blinkLedOff("orange");
		ledDriver.turnLedOff("red");
		ledDriver.turnLedOff("orange");
	}

	@Override
	public void setWarningLed()throws InterruptedException {
		ledDriver.blinkLed("orange");
		ledDriver.blinkLedOff("green");
		ledDriver.blinkLedOff("red");
		ledDriver.turnLedOff("green");
		ledDriver.turnLedOff("red");
	}

	@Override
	public void blinkLed() {
		// TODO Auto-generated method stub
		
	}
	
	private PiLed getLed(String name)
	{
		return ledsMap.get(name);
	}

}
