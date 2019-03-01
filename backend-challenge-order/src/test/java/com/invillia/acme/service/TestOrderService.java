package com.invillia.acme.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.AutoConfigureJooq;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.invillia.acme.model.Order;
import com.invillia.acme.model.OrderItem;
import com.invillia.acme.model.OrderStatus;

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
	public void testNewOrder() throws Exception {
		List<OrderItem> orderItems = Arrays.asList(new OrderItem("Pencil", 10, 0.25D));
		Order order = new Order(any(), new Date(), "123, Street", orderItems , OrderStatus.OPEN);
		
		service.create(order);

		assertNotNull("Inserting an order should have generated its ID", order.getId());
		assertNotNull("Inserting an order item should have generated its ID", order.getOrderItems().get(0).getId());
		
	}
	
	@Test
	public void testGetOrder() throws Exception {
		List<OrderItem> orderItems = Arrays.asList(new OrderItem("Pencil", 10, 0.25D));
		Order order = new Order(any(), new Date(), "123, Street", orderItems , OrderStatus.OPEN);
		
		service.create(order);
		
		Order retrievedOrder = service.get(order.getId());

		assertNotNull("Inserting an order should have generated its ID", order.getId());
		assertNotNull("Inserting an order item should have generated its ID", order.getOrderItems().get(0).getId());
		
	}
	
	
	
}
