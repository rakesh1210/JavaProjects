package com.rakesh.test.collection.hashmap;

public class CustomeHashMap<K, V> {
	
	private CustomEntry<K, V>[] table;
	
	private int capacity =4;
	
	
	public CustomeHashMap(){
		table  = new CustomEntry[capacity];
	}
	
	public void put(K newKey, V data){
	       if(newKey==null)
	           return;    //does not allow to store null.
	      
	       //calculate hash of key.
	       int hash=hash(newKey);
	       //create new entry.
	       CustomEntry<K,V> newEntry = new CustomEntry<K,V>(newKey, data, null);
	      
	       //if table location does not contain any entry, store entry there.
	        if(table[hash] == null){
	         table[hash] = newEntry;
	        }else{
	        	CustomEntry<K,V> previous = null;
	        	CustomEntry<K,V> current = table[hash];
	           
	           while(current != null){ //we have reached last entry of bucket.
	           if(current.key.equals(newKey)){           
	               if(previous==null){  //node has to be insert on first of bucket.
	                     newEntry.next=current.next;
	                     table[hash]=newEntry;
	                     return;
	               }
	               else{
	                   newEntry.next=current.next;
	                   previous.next=newEntry;
	                   return;
	               }
	           }
	           previous=current;
	             current = current.next;
	         }
	         previous.next = newEntry;
	        }
	    }
	 
	    /**
	     * Method returns value corresponding to key.
	     * @param key
	     */
	    public V get(K key){
	        int hash = hash(key);
	        if(table[hash] == null){
	         return null;
	        }else{
	        	CustomEntry<K,V> temp = table[hash];
	         while(temp!= null){
	             if(temp.key.equals(key))
	                 return temp.value;
	             temp = temp.next; //return value corresponding to key.
	         }         
	         return null;   //returns null if key is not found.
	        }
	    }
	 
	 
	    /**
	     * Method removes key-value pair from HashMapCustom.
	     * @param key
	     */
	    public boolean remove(K deleteKey){
	       
	       int hash=hash(deleteKey);
	              
	      if(table[hash] == null){
	            return false;
	      }else{
	    	  CustomEntry<K,V> previous = null;
	    	  CustomEntry<K,V> current = table[hash];
	        
	        while(current != null){ //we have reached last entry node of bucket.
	           if(current.key.equals(deleteKey)){               
	               if(previous==null){  //delete first entry node.
	                     table[hash]=table[hash].next;
	                     return true;
	               }
	               else{
	                     previous.next=current.next;
	                      return true;
	               }
	           }
	           previous=current;
	             current = current.next;
	          }
	        return false;
	      }
	    
	    }
	   
	 
	    /**
	     * Method displays all key-value pairs present in HashMapCustom.,
	     * insertion order is not guaranteed, for maintaining insertion order
	     * refer LinkedHashMapCustom.
	     * @param key
	     */
	    public void display(){
	       
	       for(int i=0;i<capacity;i++){
	           if(table[i]!=null){
	        	   CustomEntry<K, V> entry=table[i];
	                  while(entry!=null){
	                        System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
	                        entry=entry.next;
	                  }
	           }
	       }             
	    
	    }
	    /**
	     * Method implements hashing functionality, which helps in finding the appropriate
	     * bucket location to store our data.
	     * This is very important method, as performance of HashMapCustom is very much
	     * dependent on  this method's implementation.
	     * @param key
	     */
	    private int hash(K key){
	        return Math.abs(key.hashCode()) % capacity;
	    }
	

}
