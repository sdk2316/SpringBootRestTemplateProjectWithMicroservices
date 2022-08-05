package com.durgesh.client;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.durgesh.model.User;

@RestController
public class ConsumeUserWebService {
   @Autowired
   RestTemplate restTemplate;

   // Gel All Users
	//
	//
   @GetMapping(value = "/template/allusers")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange("http://localhost:9088/user/getAllUsers", HttpMethod.GET, entity, String.class).getBody();
   }
   
   // Create User
   @PostMapping(value = "/template/createUser")
   public String createUser(@RequestBody User user) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
      // User addedUser = restTemplate.postForObject("http://localhost:9088/user/create", entity, User.class);
      // return addedUser;
      return restTemplate.exchange("http://localhost:9088/user/create", HttpMethod.POST, entity, String.class).getBody();
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
   @PutMapping(value = "/template/updateUser")
   public String updateUser( @RequestBody User user) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<User> entity = new HttpEntity<User>(user,headers);
	      
	      return restTemplate.exchange( "http://localhost:9088/user/updateUser", HttpMethod.PUT, entity, String.class).getBody();
	   }
   
   //Delete User
   //@RequestMapping(value = "/template/user/{id}", method = RequestMethod.DELETE)
   @DeleteMapping(value="/template/user/{id}")
   public String deleteUsert(@PathVariable("id") String id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<User> entity = new HttpEntity<User>(headers);
      
      return restTemplate.exchange(
         "http://localhost:9088/user/deleteUser/"+id, HttpMethod.DELETE, entity, String.class).getBody();
   }

}
