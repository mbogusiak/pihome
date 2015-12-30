package com.marcin.pihome.facades;

public interface LedFacade {
	void setErrorLed() throws InterruptedException;
	void setOkLed()throws InterruptedException;;
	void setWarningLed()throws InterruptedException;;
	void blinkLed();
}
