package com.rakesh.test.general;

import java.util.HashMap;
import java.util.Map;

public class Fibnacci {
	private static Map<Integer, Integer> fibnacciMap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
       
    	// try to print fibnacci series
    	for (int i = 0; i <= 12; i++) {
			System.out.println( fibonacciRecursion(i));
		}
        // print specific position value of series
        System.out.println(getFibonacci(12)); 
    }

    public static int getFibonacci(int fibIndex) {
    	
    	if(fibIndex<0){
    		return 0;
    	}
    	fibnacciMap.put(1, 0);
    	fibnacciMap.put(2, 1);
        if (fibnacciMap.containsKey(fibIndex)) {
            return fibnacciMap.get(fibIndex);
        } else {
            int answer = getFibonacci(fibIndex - 1) + getFibonacci(fibIndex - 2);
          //  fibnacciMap.put(fibIndex, answer);
            return answer;
        }
    }
    
    public static int fibonacciRecursion(int number){
    	if(number == 0 ){
    		return 0;
    	}else if (number== 1) {
    		return 1;
			
		}else{
    		return fibonacciRecursion(number-1)+fibonacciRecursion(number-2);
    	}
    	
    	
    }

}
