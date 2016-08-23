package com.ds.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Misc {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);list.add(2);list.add(1);list.add(15);list.add(2);list.add(4);
		System.out.println(smallestNonconstructibleValue(list));
		System.out.println(getBitCount(60));
		System.out.println(getParity(60));
		System.out.println(swapBits(73, 1, 6));
		System.out.println(reverseBit(2));
		System.out.println(closestIntSameBitCount(5));
		System.out.println(multiply(2, 5));
		System.out.println(divide(15, 3));
	}
	
	private static int smallestNonconstructibleValue(List<Integer> list){
		Collections.sort(list);
		int sum = 0;
		for(int i : list){
			if(i > (sum+1)){
				return sum + 1;
			}
			sum += i;
		}
		return sum + 1;
	}
	
	private static int getBitCount(int number){
		int count = 0;
		while(number != 0){
			if(number%2 != 0){
				count++;
			}
			number = number >>> 1;
		}
		return count;
	}
	
	private static int getParity(int number){
		int parity = 0;
		while(number != 0){
			if((number & 1) == 1){
				parity = parity ^ 1;
			}
			number = number >>> 1;
		}
		return parity;
	}
	
	private static int swapBits(int number, int i, int j){
		if(((number >>> i) & 1) != ((number >>> j) & 1)){
			int mask = (int)(Math.pow(2, i) + Math.pow(2, j));
			number = number ^ mask;
		}
		return number;
	}
	
	private static int reverseBit(int number){
		int store = 0;
		while(number != 0){
			store = store << 1; //shift 1 bit to left
			store = store | (number & 1); // AND with 1 to get the last bit of the number and | to set that bit into store
			number = number >> 1;
		}
		return store;
	}
	
	private static int closestIntSameBitCount(int number){
		int bits = 63;
		for(int i = 0; i < bits; i++){
			if(((number >>> i) & 1) != ((number >>> i + 1) & 1)){
				number = number ^ ((1 << i) | (1 << (i+1)));
				return number;
			}
		}
		return number;
	}
	
	private static int multiply(int x, int y){
		int result = 0, i = 0;
		while(x != 0){
			if((x & 1) == 1){
				result = add(result, y << i);
			}
			x = x >>> 1;
			i++;
		}
		return result;
	}
	
	private static int add(int x, int y){
		int result = 0, carry = 0, i = 0, temp = 0;
		while((x != 0) || (y != 0) || carry == 1){
			temp = (carry ^ (x & 1) ^ (y & 1));
			temp <<= i;
			result = result | temp ;
			if((((x & 1) & (y & 1)) == 1) | (((x & 1) & carry)==1) | (((y & 1) & carry)==1)){
				carry = 1;
			}
			else{
				carry = 0;	
			}
			x >>>= 1;
			y >>>= 1;
			i++;
		}
		return result;
	}
	
	private static int divide(int x, int y){
		int quotient = 0;
		while(x >= y){
			int i = 0;
			while((y << i) <= x){
				i++;
			}
			quotient += (1 << (i-1));
			x = x - (y << (i-1));
		}
		return quotient;
	}
}
