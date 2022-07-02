package com.org.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.TradeRepo;
import com.org.model.Trade;

@Service
public class TradeService {

	@Autowired
	TradeRepo tradeRepo;

	public Trade createTrade(Trade trade) {

		validateTradeVersion(trade);

		validateTradeByDate(trade);

		trade.setCreatedDate(LocalDate.now());
		tradeRepo.save(trade);

		return trade;

	}

	public List<Trade> getAllTrades() {
		return tradeRepo.findAll();
	}

	public void updateTradeExpiry() {
		// TODO Auto-generated method stub
		List<Trade> trades = tradeRepo.findAll();
		trades.stream().forEach(trade -> {	

			if (trade.getMaturityDate().isBefore(LocalDate.now())) {
				trade.setExpired("Y");
				tradeRepo.save(trade);
			}
		});
	}

	private void validateTradeVersion(Trade newTrade) {

		Optional<Trade> persistedTrade = tradeRepo.findById(newTrade.getTradeId());
		if (persistedTrade.isPresent()) {
			if (persistedTrade.get().getVersion() > newTrade.getVersion()) {
				throw new RuntimeException("Lower trade version received");
			}

		}

	}

	private void validateTradeByDate(Trade newTrade) {

		if(newTrade.getMaturityDate().isBefore(LocalDate.now())) {
			throw new RuntimeException("Trade Maturity date is older date");
		}

	}
}
