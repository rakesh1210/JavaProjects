package com.rakesh.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="")

public class MyLearningUserAppDao {
	public List<MyLearningAppUser> getAllMyLearningAppUsers(){ 
	  List<MyLearningAppUser> myLearningAppUserList = null; 
      try { 
         File file = new File("MyLearningAppUser.dat"); 
         if (!file.exists()) { 
        	 MyLearningAppUser user = new MyLearningAppUser(1, "Rakesh", "Devloper"); 
        	 myLearningAppUserList = new ArrayList<MyLearningAppUser>(); 
        	 myLearningAppUserList.add(user); 
        	 saveMyLearningAppUserList(myLearningAppUserList); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            myLearningAppUserList = (List<MyLearningAppUser>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return myLearningAppUserList; 
   } 
	
	
   public MyLearningAppUser getMyLearningAppUser(int id){ 
	      List<MyLearningAppUser> myLearningAppUsers = getAllMyLearningAppUsers();  
	      for(MyLearningAppUser myLearningAppUser: myLearningAppUsers){ 
	         if(myLearningAppUser.getId() == id){ 
	            return myLearningAppUser; 
	         } 
	      } 
	      return null; 
	   } 
   
	public int addMyLearningAppUser(MyLearningAppUser pUser){ 
	      List<MyLearningAppUser> myLearningAppUsers = getAllMyLearningAppUsers(); 
	      boolean userExists = false; 
	      for(MyLearningAppUser myLearningAppUser: myLearningAppUsers){ 
	         if(myLearningAppUser.getId() == pUser.getId()){ 
	            userExists = true; 
	            break; 
	         } 
	      }   
	      if(!userExists){ 
	    	  myLearningAppUsers.add(pUser); 
	    	  saveMyLearningAppUserList(myLearningAppUsers); 
	         return 1; 
	      } 
	      return 0; 
	   }
	  
	public int updateMyLearningAppUser(MyLearningAppUser pUser){ 
	      List<MyLearningAppUser> userList = getAllMyLearningAppUsers();  
	      for(MyLearningAppUser user: userList){ 
	         if(user.getId() == pUser.getId()){ 
	            int index = userList.indexOf(user);    
	            userList.set(index, pUser); 
	            saveMyLearningAppUserList(userList); 
	            return 1; 
	         } 
	      }   
	      return 0; 
	   }  
	   
	public int deleteMyLearningAppUser(int id){ 
	      List<MyLearningAppUser> userList = getAllMyLearningAppUsers();  
	      for(MyLearningAppUser user: userList){ 
	         if(user.getId() == id){ 
	            int index = userList.indexOf(user);    
	            userList.remove(index); 
	            saveMyLearningAppUserList(userList); 
	            return 1;    
	         } 
	      }   
	      return 0; 
	   }  
	   
	   
	private void saveMyLearningAppUserList(List<MyLearningAppUser> userList){ 
		      try { 
		         File file = new File("MyLearningAppUser.txt"); 
		         FileOutputStream fos;  
		         fos = new FileOutputStream(file); 
		         ObjectOutputStream oos = new ObjectOutputStream(fos); 
		         oos.writeObject(userList); 
		         oos.close(); 
		      } catch (FileNotFoundException e) { 
		         e.printStackTrace(); 
		      } catch (IOException e) { 
		         e.printStackTrace(); 
		      } 
		   } 
}
