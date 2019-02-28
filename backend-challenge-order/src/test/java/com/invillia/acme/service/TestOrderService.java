package com.invillia.acme.service;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureJooq
@Transactional 
public class TestOrderService {

	@Autowired
	private OrderService service;
	
	@Autowired
	private DSLContext jooq;
	
	@Test
	public void testNewPayment() throws Exception {
		
	}
	
}
