package com.rakesh.test.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		
		System.out.println(uniqueCharaterString("Test"));
		System.out.println(uniqueCharString("Testab"));
	}
	
	/**
	 * Method to check the unique character in given String
	 * using map
	 * @param input
	 * @return
	 */
	public static boolean uniqueCharaterString(String input){
		
		if(input == null){
			return false;
		}
		
		boolean testbool = true;
		Map<String, Integer> uniqueMap =  new HashMap<String, Integer>();
		for(int  i = 0; i< input.length(); i++){
			String str  = String.valueOf(input.charAt(i));
			if(uniqueMap.get(str)!= null && uniqueMap.get(str)>0){
				testbool = false;
				break;
			}else{
				int j =0 ;
				if(uniqueMap.get(str)!= null){
					j+=uniqueMap.get(str).intValue();
				}

				uniqueMap.put(str, ++j);
			}
		}
		return testbool;
	}
	
	/**
	 * Method to check the unique character in given String
	 * using set
	 * @param input
	 * @return
	 */
	public static boolean uniqueCharString(String input){
		
		if(input == null){
			return false;
		}
		
		boolean testbool = true;
		Set<Character> uniqueSet = new HashSet<Character>();
		for(int  i = 0; i< input.length(); i++){
			if(!uniqueSet.add(input.charAt(i))){
				testbool= false;
				break;
			}
			
		}
		return testbool;
	}
}
