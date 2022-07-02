package com.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Trade;

@Repository
public interface TradeRepo extends JpaRepository<Trade, String> {
	
	 

}
