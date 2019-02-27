package com.invillia.acme.service.impl;

import static com.invillia.acme.jooq.tables.Store.STORE;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.service.StoreService;

@Service
@Transactional(transactionManager = "transactionManager")
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private DSLContext jooq;

	@Override
	public String test() {
		String result;
		
		try {
			result = this.jooq
			.select
				(STORE.NAME)
			.from
				(STORE)
			.limit(1)
			.fetchOne()
			.value1();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return result;
	}
	
}
