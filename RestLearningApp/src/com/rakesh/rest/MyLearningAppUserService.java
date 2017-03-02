package com.rakesh.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/MyLearningAppUserService")
//http://localhost:8080/RestLearningApp/rest/MyLearningAppUserService/myLearningAppUsers
public class MyLearningAppUserService {
	
	  MyLearningUserAppDao userDao = new MyLearningUserAppDao();  
	   @GET 
	   @Path("/myLearningAppUsers") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<MyLearningAppUser> getUsers(){ 
	      return userDao.getAllMyLearningAppUsers(); 
	   } 

}
