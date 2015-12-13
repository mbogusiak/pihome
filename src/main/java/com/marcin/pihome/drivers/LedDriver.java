package com.marcin.pihome.drivers;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.marcin.pihome.pojo.PiLed;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Component

public class LedDriver {

	private Logger log = Logger.getLogger(LedDriver.class.getName());
	private GpioController gpio = null;
	private GpioPinDigitalOutput ledRed;
	private GpioPinDigitalOutput ledGreen;
	private GpioPinDigitalOutput ledOrange;

	@Resource
	 Map<String, PiLed> leds;
	
	@PostConstruct
	public void populateMovieCache() {System.out.println("??aSD");
//		System.out.println(leds);
//		try
//		{
//			gpio = GpioFactory.getInstance();
//			ledRed = gpio.provisionDigitalOutputPin(
//					RaspiPin.GPIO_01, "MyLED", PinState.LOW);
//			
//			ledGreen = gpio.provisionDigitalOutputPin(
//					RaspiPin.GPIO_05, "ledGreen", PinState.LOW);
//			
//			ledOrange = gpio.provisionDigitalOutputPin(
//					RaspiPin.GPIO_04, "ledOrange", PinState.LOW);
//			
//			
//		}
//		catch(Exception exception)
//		{
//			log.error("There was a problem with accessing RasperryPI. Are you running this progam on rpi device?");
//		}


	}
	

	public void test() throws InterruptedException {
		// create gpio controller

		// provision gpio pin #01 as an output pin and turn on
//		new Thread(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				ledRed.setShutdownOptions(true, PinState.HIGH);
//
//				System.out.println("--> GPIO state should be: ON");
//
//				try {
//					ledRed.high();
//					Thread.sleep(500);
//					// turn off gpio pin #01
//					ledRed.low();
//					System.out.println("--> GPIO state should be: OFF");
//
//					Thread.sleep(500);
//
//					// toggle the current state of gpio pin #01 (should turn on)
//					ledRed.toggle();
//					System.out.println("--> GPIO state should be: ON");
//
//					Thread.sleep(1000);
//
//					// toggle the current state of gpio pin #01 (should turn off)
//					ledRed.toggle();
//					System.out.println("--> GPIO state should be: OFF");
//
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}).start();


	}
	
	public void turnRedLedOn() throws InterruptedException {
		ledRed.high();

	}
	
	public void turnRedLedOff() throws InterruptedException {
		ledRed.low();
	}
	
	
	
	public void turnGreenLedOn() throws InterruptedException {
		System.out.println("turnGreenLedOn");
		ledGreen.high();

	}
	
	public void turnGreenLedOff() throws InterruptedException {
		System.out.println("turnGreenLedOff");

		ledGreen.low();
	}
	
	public void turnOrangeLedOn() throws InterruptedException {
		System.out.println("turnOrangeLedOn");

		ledOrange.high();

	}
	
	public void turnOrangeLedOff() throws InterruptedException {
		System.out.println("turnOrangeLedOff");

		ledOrange.low();
	}
	@PreDestroy
	public void clearMovieCache() {
//		gpio.shutdown();
	}
}
