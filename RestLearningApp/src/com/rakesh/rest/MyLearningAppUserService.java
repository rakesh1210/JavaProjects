package com.rakesh.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/MyLearningAppUserService")
//http://localhost:8080/RestLearningApp/rest/MyLearningAppUserService/myLearningAppUsers
public class MyLearningAppUserService {
	
	  MyLearningUserAppDao userDao = new MyLearningUserAppDao();  
	  
	  private static final String SUCCESS_RESULT = "<result>success</result>"; 
	  private static final String FAILURE_RESULT = "<result>failure</result>";  
	  
	   @GET 
	   @Path("/myLearningAppUsers") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public List<MyLearningAppUser> getUsers(){ 
	      return userDao.getAllMyLearningAppUsers(); 
	   } 
	   
	   
	   @GET 
	   @Path("/myLearningAppUsers/{myLearningAppUserId}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public MyLearningAppUser getUser(@PathParam("myLearningAppUserId") int userid){ 
	      return userDao.getMyLearningAppUser(userid); 
	   }  
	   @PUT 
	   @Path("/myLearningAppUsers") 
	   @Produces(MediaType.APPLICATION_XML) 
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public String createUser(@FormParam("id") int id, 
	      @FormParam("name") String name, 
	      @FormParam("profession") String profession, 
	      @Context HttpServletResponse servletResponse) throws IOException{ 
		   MyLearningAppUser user = new MyLearningAppUser(id, name, profession); 
	      int result = userDao.addMyLearningAppUser(user); 
	      if(result == 1){ 
	         return SUCCESS_RESULT; 
	      } 
	      return FAILURE_RESULT; 
	   }  
	   @POST 
	   @Path("/myLearningAppUsers")  
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	   public String updateUser(@FormParam("id") int id, 
	      @FormParam("name") String name, 
	      @FormParam("profession") String profession, 
	      @Context HttpServletResponse servletResponse) throws IOException{ 
		   MyLearningAppUser user = new MyLearningAppUser(id, name, profession); 
	      int result = userDao.updateMyLearningAppUser(user); 
	      if(result == 1){ 
	         return SUCCESS_RESULT; 
	      } 
	      return FAILURE_RESULT; 
	   }  
	   @DELETE 
	   @Path("/myLearningAppUsers/{userid}") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public String deleteUser(@PathParam("userid") int userid){ 
	      int result = userDao.deleteMyLearningAppUser(userid); 
	      if(result == 1){ 
	         return SUCCESS_RESULT; 
	      } 
	      return FAILURE_RESULT; 
	   }  
	   @OPTIONS 
	   @Path("/myLearningAppUsers") 
	   @Produces(MediaType.APPLICATION_XML) 
	   public String getSupportedOperations(){ 
	      return "<operations>GET, PUT, POST, DELETE</operations>"; 
	   } 

}
