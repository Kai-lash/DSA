package com.ds.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Misc {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(12);list.add(2);list.add(1);list.add(15);list.add(2);list.add(4);
		System.out.println(smallestNonconstructibleValue(list));
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

}
