package com.invillia.acme.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.invillia.acme.model.Store;
import com.invillia.acme.model.StorePage;
import com.invillia.acme.service.StoreService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class TestRestApi {
	
	@Autowired
	private TestRestTemplate restTemplate = new TestRestTemplate();
	
	@MockBean
	private StoreService storeService;
    
	@Test
	public void getAllWithoutAnyParameterSuccessfully() throws Exception {
		List<Store> mockResult = Arrays.asList(new Store(1, "One", "one", "Street One"));
		StorePage mockPage = new StorePage(mockResult);
		
		when(storeService.getAll(any())).thenReturn(mockResult);
		
		ResponseEntity<StorePage> response = restTemplate.getForEntity("/stores", StorePage.class);
		
		verify(storeService, times(1)).getAll(any());
		assertEquals("Status Code is 200 - OK", response.getStatusCode(), HttpStatus.OK);
		assertNotNull("Response is not null", response.getBody());
		assertThat(response.getBody()).isEqualToComparingFieldByFieldRecursively(mockPage);
	}
    
	@Test
	public void getAllWithoutAnyParameterEmpty() throws Exception {
		when(storeService.getAll(any())).thenReturn(new ArrayList<>());
		
		ResponseEntity<StorePage> response = restTemplate.getForEntity("/stores", StorePage.class);
		
		verify(storeService, times(1)).getAll(any());
		assertEquals("Status Code is 404", response.getStatusCode(), HttpStatus.NOT_FOUND);
		assertNull("Response is null", response.getBody());
	}

	@Test
	public void getStoreByIdSuccessfully() throws Exception {
		Store store = new Store(1, "One", "one", "Street One");
		
		when(storeService.find(any()))
			.thenReturn(store);
		
		ResponseEntity<Store> response = restTemplate.getForEntity("/stores/one", Store.class);
		
		verify(storeService, times(1)).find(any());
		assertEquals("Status Code is 200 - OK", response.getStatusCode(), HttpStatus.OK);
		assertNotNull("Response is not null", response.getBody());
		
		if (response.getBody() != null) {
			assertThat(response.getBody()).isEqualToComparingFieldByFieldRecursively(store);
		}
	}

	@Test
	public void getStoreById404() throws Exception {
		when(storeService.find(any())).thenReturn(null);
		
		ResponseEntity<Store> response = restTemplate.getForEntity("/stores/one", Store.class);
		
		verify(storeService, times(1)).find(any());
		assertEquals("Status Code is 404", response.getStatusCode(), HttpStatus.NOT_FOUND);
		assertNull("Response is null", response.getBody());
	}
}
