package com.invillia.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Store;

@Service
public interface StoreService {

	void create(Store store);

	void update(Store store);
	
	Store find(String code);

	List<Store> getAll(Parameters parameters);
	
	public static class Parameters {
		public String name;
		public String address;
		public String code;
	}

}
