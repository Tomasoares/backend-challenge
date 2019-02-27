package com.invillia.acme.service.impl;

import static com.invillia.acme.jooq.tables.Store.STORE;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.jooq.tables.records.StoreRecord;
import com.invillia.acme.model.Store;
import com.invillia.acme.service.StoreService;
import com.invillia.acme.service.impl.util.JooqUtils;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private DSLContext jooq;

	@Override
	public void create(Store store) {
		StoreRecord rec = new StoreRecord();
		rec.setName(store.getName());
		rec.setAddress(store.getAddress());
		rec.setCode(store.getCode());

		rec.attach(this.jooq.configuration());
		rec.store();
	}
	
	@Override
	public void update(Store store) {
		//@formatter: off
		this.jooq.update
			(STORE)
		.set(STORE.NAME, store.getName())
		.set(STORE.ADDRESS, store.getAddress())
		.where
			(STORE.CODE.eq(store.getCode()))
		.execute();
		//@formatter: on
	}

	@Override
	public List<Store> getAll(Parameters parameters) {
		//@formatter: off
		SelectQuery<Record> query = this.jooq.select
			()
		.from
			(STORE)
		.getQuery();
		//@formatter: on
		
		if (parameters.address != null) {
			query.addConditions(JooqUtils.like(STORE.ADDRESS, parameters.address));
		}
		
		if (parameters.name != null) {
			query.addConditions(JooqUtils.like(STORE.NAME, parameters.name));
		}
		
		if (parameters.code != null) {
			query.addConditions(STORE.CODE.eq(parameters.code));
		}
		
		return query.fetch(rec -> {
			Store store = new Store();
			store.setAddress(rec.getValue(STORE.ADDRESS));
			store.setCode(rec.getValue(STORE.CODE));
			store.setId(rec.getValue(STORE.ID));
			store.setName(rec.getValue(STORE.NAME));
			return store;
		});
	}

	@Override
	public Store find(String code) {
		//@formatter: off
		SelectQuery<Record> query = this.jooq.select
			()
		.from
			(STORE)
		.where
			(STORE.CODE.eq(code))
		.getQuery();
		//@formatter: on
		
		Record rec = query.fetchOne();
		
		if (rec != null) {
			Store store = new Store();
			store.setAddress(rec.getValue(STORE.ADDRESS));
			store.setCode(rec.getValue(STORE.CODE));
			store.setId(rec.getValue(STORE.ID));
			store.setName(rec.getValue(STORE.NAME));
			return store;
		}
				
		return null;
	}

	
}
