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
}
