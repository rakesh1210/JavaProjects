package com.rakesh.test.collection.hashmap;

public class CustomEntry<K,V> {
	  K key;
      V value;
      CustomEntry<K,V> next;
  
      public CustomEntry(K key, V value, CustomEntry<K,V> next){
          this.key = key;
          this.value = value;
          this.next = next;
      }
  }
  

