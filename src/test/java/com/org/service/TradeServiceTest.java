package com.org.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.org.dao.TradeRepo;
import com.org.model.Trade;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TradeServiceTest {

	@InjectMocks
	private TradeService tradeService;

	@Mock
	private TradeRepo tradeRepo;

	@Test
	public void testCreateTrade() {

		Trade trade = new Trade();
		trade.setTradeId("T1");
		trade.setMaturityDate(LocalDate.now());
		trade.setBookId("bookId");
//		Mockito.when(trade )

		Trade resultTrade = tradeService.createTrade(trade);

		Assert.assertEquals(resultTrade.getTradeId(), trade.getTradeId());
		verify(tradeRepo, times(1)).save(trade);
	}

	@Test
	public void testUpdateTradeExpiry() {

		Trade trade = new Trade();
		trade.setTradeId("T1");
		trade.setMaturityDate(LocalDate.now());
		trade.setBookId("bookId");
		List<Trade> tradeList = new ArrayList<>();
		tradeList.add(trade);
		Mockito.when(tradeRepo.findAll()).thenReturn(tradeList);

		tradeService.updateTradeExpiry();
		verify(tradeRepo, times(1)).findAll();
	}

}
