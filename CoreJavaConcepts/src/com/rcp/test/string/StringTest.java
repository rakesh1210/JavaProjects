package com.rcp.test.string;

import java.util.HashMap;
import java.util.Map;

public class StringTest {

	public static void main(String[] args) {
		
		System.out.println(uniqueCharaterString("Test"));

	}
	
	/**
	 * Method to check the unique character in given String
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
}
