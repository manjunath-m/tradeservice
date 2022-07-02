package com.org.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.org.service.TradeService;

@Component
public class TradeScheduler {

	
	@Autowired
	TradeService tradeService;
	
	@Scheduled(cron = "0/30 * * * * *") // Run every 30 seconds
	public void updateTradeExpiry() {
		System.out.println("Running scheduler");
		tradeService.updateTradeExpiry();
	}
	
}
