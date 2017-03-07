package com.rakesh.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "myLearningAppUser")
//http://localhost:8080/RestLearningApp/rest/MyLearningAppUserService/myLearningAppUsers
public class MyLearningAppUser implements Serializable {
	
	private static final long serialVersionUID = 1L; 	
	   private int id; 
	   private String name; 
	   private String profession;  
	   
	   public MyLearningAppUser(){} 
	    
	   public MyLearningAppUser(int id, String name, String profession){  
	      this.id = id; 
	      this.name = name; 
	      this.profession = profession; 
	   }  
	   public int getId() { 
	      return id; 
	   }  
	   @XmlElement 
	   public void setId(int id) { 
	      this.id = id; 
	   } 
	   public String getName() { 
	      return name; 
	   } 
	   @XmlElement
	   public void setName(String name) { 
	      this.name = name; 
	   } 
	   public String getProfession() { 
	      return profession; 
	   } 
	   @XmlElement 
	   public void setProfession(String profession) { 
	      this.profession = profession; 
	   }   
	   
	   @Override 
	   public boolean equals(Object object){ 
	      if(object == null){ 
	         return false; 
	      }else if(!(object instanceof MyLearningAppUser)){ 
	         return false; 
	      }else { 
	    	  MyLearningAppUser user = (MyLearningAppUser)object; 
	         if(id == user.getId() 
	            && name.equals(user.getName()) 
	            && profession.equals(user.getProfession())){ 
	               return true; 
	         }
	      } 
	      return false; 
	   }  
	} 