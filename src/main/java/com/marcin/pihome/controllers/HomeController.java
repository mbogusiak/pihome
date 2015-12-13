package com.marcin.pihome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcin.pihome.drivers.LedDriver;

@Controller
public class HomeController {

	@Autowired
	private LedDriver ledDriver;
	
    @RequestMapping("/ledtest")
	public ResponseEntity<Void> user() throws InterruptedException {
    	ledDriver.test();
    	System.out.println("TEST LEDOW");
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}
    
    @RequestMapping("/turnRedOn")
	public ResponseEntity<Void> turnRedLedOn() throws InterruptedException {
    	ledDriver.turnRedLedOn();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}
    
    @RequestMapping("/turnRedOff")
	public ResponseEntity<Void> turnRedLedOff() throws InterruptedException {
    	ledDriver.turnRedLedOff();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}

    
    
    @RequestMapping("/turnGreenOn")
	public ResponseEntity<Void> turnGreenLedOn() throws InterruptedException {
    	ledDriver.turnGreenLedOn();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}
    
    @RequestMapping("/turnGreenOff")
	public ResponseEntity<Void> turnGreenLedOff() throws InterruptedException {
    	ledDriver.turnGreenLedOff();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}

    
    @RequestMapping("/turnOrangeOn")
	public ResponseEntity<Void> turnOrangeLedOn() throws InterruptedException {
    	ledDriver.turnOrangeLedOn();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}
    
    @RequestMapping("/turnOrangeOff")
	public ResponseEntity<Void> turnOrangeLedOff() throws InterruptedException {
    	ledDriver.turnOrangeLedOff();
    	return new ResponseEntity<Void>( HttpStatus.OK );
	}

}