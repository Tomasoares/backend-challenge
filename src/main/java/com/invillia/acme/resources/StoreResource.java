package com.invillia.acme.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreService;
import com.invillia.acme.service.StoreService.Parameters;

@RestController
@RequestMapping("/order")
public class StoreResource {
	
	@Autowired
	StoreService service;
	
	private static final String storeCode = "storeCode";

	@GetMapping("/{storeCode}")
	public Store findStore(@PathVariable("storeCode") String storeCode) {
		return this.service.find(storeCode);
	}
	
	@PostMapping
	public Store create(@RequestBody Store store) {
		this.service.create(store);
		return store;
	}
	
	@PutMapping("/{storeCode}")
	public Store update(@RequestBody Store store, @PathVariable("storeCode") String code) {
		store.setCode(code);
		this.service.update(store);
		return store;
	}
	
	@GetMapping
	public List<Store> getAll(@RequestParam(required = false) String address, 
							  @RequestParam(required = false) String code,
							  @RequestParam(required = false) String name) {
		
		Parameters parameters = new Parameters();
		parameters.address = address;
		parameters.code = code;
		parameters.name = name;
		
		return this.service.getAll(parameters);
		
	}
}
