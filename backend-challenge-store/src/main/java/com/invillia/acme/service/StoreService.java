package com.invillia.acme.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invillia.acme.model.Store;
import com.invillia.acme.model.filter.StoreGetAllFilter;

@Service
public interface StoreService {

	void create(Store store);

	void update(Store store);
	
	Store find(String code);

	List<Store> getAll(StoreGetAllFilter parameters);

}
