package com.invillia.acme.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorePage {

	private List<Store> stores = new ArrayList<>();
	
	public StorePage() {
		
	}
	
	public StorePage(Store...stores) {
		this.stores.addAll(Arrays.asList(stores));
	}
	
	public StorePage(List<Store> stores) {
		this.stores.addAll(stores);
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
}
