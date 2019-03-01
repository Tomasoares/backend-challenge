package com.invillia.acme.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.model.Store;
import com.invillia.acme.model.StorePage;
import com.invillia.acme.model.filter.StoreGetAllFilter;
import com.invillia.acme.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreResource {
	
	@Autowired
	private StoreService service;

	@GetMapping("/storeCode")
	public ResponseEntity<Store> findStore(@PathVariable("storeCode") String storeCode) {
		Store find = this.service.find(storeCode);
		
		if (find == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(find);
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
	public ResponseEntity<StorePage> getAll(@RequestParam(required = false) String address, 
							  				@RequestParam(required = false) String code,
							  				@RequestParam(required = false) String name) {
		
		StoreGetAllFilter parameters = new StoreGetAllFilter();
		parameters.address = address;
		parameters.code = code;
		parameters.name = name;
		
		List<Store> stores = this.service.getAll(parameters);
		
		if (stores.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(new StorePage(stores));
		
	}
}
