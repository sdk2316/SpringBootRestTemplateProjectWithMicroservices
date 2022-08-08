package com.durgesh.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.durgesh.model.OrderDetails;

@RestController
public class ConsumeOrderWebService {
	@Autowired
	RestTemplate restTemplate;

	// Gel All Users

	@GetMapping(value = "/order/getAllOrders")
	public String getProductList() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8000/order/getAllOrder", HttpMethod.GET, entity, String.class)
				.getBody();
	}

	// Create User
	@PostMapping(value = "/order/saveOrder")
	public String createUser(@RequestBody OrderDetails details) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(details, headers);
		// User addedUser =
		// restTemplate.postForObject("http://localhost:9088/user/create", entity,
		// User.class);
		// return addedUser;
		return restTemplate.exchange("http://localhost:8000/order/saveOrder", HttpMethod.POST, entity, String.class)
				.getBody();
	}

	// Update User
	@PutMapping(value = "/order/updateOrderDetails/{id}")
	public String updateUser(@RequestBody OrderDetails orderDetails, @PathVariable("id") Integer id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(orderDetails, headers);

		return restTemplate
				.exchange("http://localhost:8000/order/updateOrder/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	// Delete User
	// @RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
	@DeleteMapping(value = "/deleteOrder/{id}")
	public String deleteUsert(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:8000/order/deleteorder/" + id,
				HttpMethod.DELETE, entity, String.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			System.out.println(response.getBody());
		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}
		return response.getBody();

	}
	
	// Pagination
	
	@GetMapping(value = "/Pagination/{pageNo}/{pageSize}")
	public OrderDetails[] getPagination(@PathVariable int pageNo, @PathVariable int pageSize) {

		ResponseEntity<OrderDetails[]> response = restTemplate
				.getForEntity("http://localhost:8000/order/OrderDetails/" + pageNo+"/"+pageSize, OrderDetails[].class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			System.out.println(response.getBody());
		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}
		return response.getBody();
	}

	// Get By ID
	// @RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
	// @GetMapping(value="/order/search/{customerName}",produces =
	// {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@GetMapping(value = "/order/ById/{id}")
	public OrderDetails getOrderById(@PathVariable("id") String id) {

		ResponseEntity<OrderDetails> response = restTemplate
				.getForEntity("http://localhost:8000/order/getOneOrder/" + id, OrderDetails.class);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			System.out.println(response.getBody());
		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}
		return response.getBody();
	}

	// DisableProductById
	@GetMapping(value = "/order/disableProductById/{id}")
	public void disableProduct(@PathVariable("id") Integer id) {

		restTemplate.put("http://localhost:8000/order/disableProduct/" + id, String.class);

	}

	// EnableProductById
	@GetMapping(value = "/order/enableProductById/{id}")
	public void enableProduct(@PathVariable("id") Integer id) {

		restTemplate.put("http://localhost:8000/order/enableProduct/" + id, String.class);

	}

	// Get By customerName

	@GetMapping(value = "/order/getBycustomerName/{customerName}")
	public List<OrderDetails> getBycustomerName(@PathVariable("customerName") String customerName) {

		ResponseEntity<OrderDetails[]> response = restTemplate
				.getForEntity("http://localhost:8000/order/getAllOrderName/" + customerName, OrderDetails[].class);
		return Arrays.asList(response.getBody());

	}

	// Get By customerName

	@GetMapping(value = "/order/searchBycustomerName/{customerName}")
	public List<Object> searchBycustomerName(@PathVariable("customerName") String customerName) {

		ResponseEntity<Object[]> response = restTemplate
				.getForEntity("http://localhost:8000/order/search/" + customerName, Object[].class);
		return Arrays.asList(response.getBody());

	}
}
