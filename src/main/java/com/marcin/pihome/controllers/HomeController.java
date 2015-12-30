package com.marcin.pihome.controllers;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcin.pihome.core.services.impl.DefaultLedService;

@Controller
public class HomeController {

	@Resource
	private DefaultLedService ledService;

	@RequestMapping("/turnRedOn")
	public ResponseEntity<Void> turnRedLedOn() {
		ledService.turnLedOn("red");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnRedOff")
	public ResponseEntity<Void> turnRedLedOff() throws InterruptedException {
		ledService.turnLedOff("red");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnGreenOn")
	public ResponseEntity<Void> turnGreenLedOn() throws InterruptedException {
		ledService.turnLedOn("green");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnGreenOff")
	public ResponseEntity<Void> turnGreenLedOff() throws InterruptedException {
		ledService.turnLedOff("green");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnOrangeOn")
	public ResponseEntity<Void> turnOrangeLedOn() throws InterruptedException {
		ledService.turnLedOn("orange");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping("/turnOrangeOff")
	public ResponseEntity<Void> turnOrangeLedOff() throws InterruptedException {
		ledService.turnLedOff("orange");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}