package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Trade;
import com.org.service.TradeService;

@RestController
public class TradeController {

	
	@Autowired
	TradeService tradeService;
	
	@PostMapping("/v1/trades")
	public ResponseEntity<String> createTrade(@RequestBody Trade trade){
		
		
		tradeService.createTrade(trade);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
	}
	
	@GetMapping("/v1/trades")
	public ResponseEntity<?> getTrades(){
		
		
		List<Trade> trades = tradeService.getAllTrades();
		
		return new ResponseEntity<>(trades, HttpStatus.OK);
		
	}
	
}
