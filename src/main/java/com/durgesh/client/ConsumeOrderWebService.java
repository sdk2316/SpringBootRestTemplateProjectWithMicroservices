package com.durgesh.client;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
import com.durgesh.model.User;

@RestController
public class ConsumeOrderWebService {
   @Autowired
   RestTemplate restTemplate;

   // Gel All Users
	// hello
	//
   @GetMapping(value = "/order/getAllOrders")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange("http://localhost:8000/order/getAllOrder", HttpMethod.GET, entity, String.class).getBody();
   }
   
   // Create User
   @PostMapping(value = "/order/saveOrder")
   public String createUser(@RequestBody OrderDetails details ) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<OrderDetails> entity = new HttpEntity<OrderDetails>(details,headers);
      // User addedUser = restTemplate.postForObject("http://localhost:9088/user/create", entity, User.class);
      // return addedUser;
      return restTemplate.exchange("http://localhost:8000/order/saveOrder", HttpMethod.POST, entity, String.class).getBody();
   }
   
   // OR
   
  /* @PostMapping(value = "/template/createUser")
   public User createUser(@RequestBody User user) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
       User addedUser = restTemplate.postForObject("http://localhost:9088/user/create", entity, User.class);
       return addedUser;
     // return restTemplate.exchange("http://localhost:9088/user/create", HttpMethod.POST, entity, String.class).getBody();
   }
   */
   
   //Update User
   @PutMapping(value = "/order/updateUser")
   public String updateUser( @RequestBody User user) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
	      
	      return restTemplate.exchange( "http://localhost:9088/user/updateUser", HttpMethod.PUT, entity, String.class).getBody();
	   }
   
   //Delete User
   //@RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
   @DeleteMapping(value="/order/user/{id}")
   public String deleteUsert(@PathVariable("id") String id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<User> entity = new HttpEntity<User>(headers);
      
      return restTemplate.exchange(
         "http://localhost:9088/user/deleteUser/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   }
   
  
	   
	 //Get By ID
	   //@RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
	  // @GetMapping(value="/order/search/{customerName}",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
   		@GetMapping(value="/order/ById/{id}")
	   public OrderDetails getOrderById(@PathVariable("id") String id) {
		   
   			ResponseEntity<OrderDetails> response = restTemplate.getForEntity("http://localhost:8000/order/getOneOrder/" +id, OrderDetails.class);
   			
   	// ResponseEntity<String> response = restTemplate.exchange(, HttpMethod.GET, headers, String.class,id);
   	 
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
       
	   }
	   
	   
	   


