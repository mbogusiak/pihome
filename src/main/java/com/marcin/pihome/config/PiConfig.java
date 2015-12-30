package com.marcin.pihome.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.marcin.pihome.pojo.PiLed;
import com.mongodb.MongoClient;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@Configuration
public class PiConfig {

	@Bean(name = { "piMap" })
	public Map<Integer, Pin> piMap() {
		Map<Integer, Pin> pinsMap = new HashMap<Integer, Pin>();
		pinsMap.put(18, RaspiPin.GPIO_01);
		pinsMap.put(23, RaspiPin.GPIO_05);
		pinsMap.put(24, RaspiPin.GPIO_04);
		return pinsMap;
	}

	@Bean(name = "piLeds")
	public Map<String, PiLed> piLeds() {
		
		Map<String, PiLed> leds = new HashMap<String, PiLed>();
		PiLed redLed = new PiLed("red", 18);
		leds.put("red", redLed);
		PiLed greenLed = new PiLed("green", 23);
		leds.put("green", greenLed);
		PiLed orangeLed = new PiLed("orange", 24);
		leds.put("orange", orangeLed);
		return leds;
	}

	@Bean
	public GpioController gpioController() {

		GpioController gpioController = GpioFactory.getInstance();
		return gpioController;
	}

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "pihomedb");
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}
	
	@PostConstruct
	public void buildLeds() {
		try {
			for (PiLed piLed : piLeds().values()) {
				GpioPinDigitalOutput gpio = createGpio(piLed);
				piLed.setGpio(gpio);
			}
		} catch (Exception exception) {
//			log.error("There was a problem with accessing RasperryPI. Are you running this progam on rpi device?");
		}
	}

	private GpioPinDigitalOutput createGpio(PiLed piLed) {
		Pin pin = piMap().get(piLed.getPinNr());
		GpioPinDigitalOutput gpio = gpioController().provisionDigitalOutputPin(
				pin, piLed.getName(), PinState.LOW);
		return gpio;
	}

	@PreDestroy
	public void turnGpioOff() {
		gpioController().shutdown();
	}

}
