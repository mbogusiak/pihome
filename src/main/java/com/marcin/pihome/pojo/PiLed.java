package com.marcin.pihome.pojo;

public class PiLed {
	
	private String name;
	private int pinNr;
	
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

}
