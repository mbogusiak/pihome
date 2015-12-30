package com.marcin.pihome.pojo;

import com.pi4j.io.gpio.GpioPinDigitalOutput;

public class PiLed {
	
	private String name;
	private int pinNr;
	private GpioPinDigitalOutput gpio;
	
	public PiLed(String name, int pinNr)
	{
		this.setName(name);
		this.setPinNr(pinNr);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPinNr() {
		return pinNr;
	}

	public void setPinNr(int pinNr) {
		this.pinNr = pinNr;
	}

	public GpioPinDigitalOutput getGpio() {
		return gpio;
	}

	public void setGpio(GpioPinDigitalOutput gpio) {
		this.gpio = gpio;
	}

}
