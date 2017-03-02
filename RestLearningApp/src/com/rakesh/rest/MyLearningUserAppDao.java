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
        	 MyLearningAppUser user = new MyLearningAppUser(1, "Rakesh", "Teacher"); 
        	 myLearningAppUserList = new ArrayList<MyLearningAppUser>(); 
        	 myLearningAppUserList.add(user); 
            saveUserList(myLearningAppUserList); 
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
	
	
   private void saveUserList(List<MyLearningAppUser> userList){ 
      try { 
         File file = new File("MyLearningAppUser.dat"); 
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
