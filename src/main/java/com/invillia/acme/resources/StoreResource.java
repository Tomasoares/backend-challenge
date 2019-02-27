package com.invillia.acme.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.service.StoreService;

@RestController
@RequestMapping("/order")
public class StoreResource {
	
	@Autowired
	StoreService service;

	@RequestMapping("{storeId}")
	public String findStore(@PathVariable("storeId") String storeId) {
		return this.service.test();
	}
	
}
