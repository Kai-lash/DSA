package com.arrayAndString;

import java.util.HashMap;

public class ArrayStringTest {

	public static void main(String[] args) {
		for(int i : evenOdd(new int[]{1,2,3,4,5,6,7,8,9})){
			System.out.print(i + " ");
		}
		
		System.out.println();
		for(int i : dutchFlagPartition(new int[]{1,2,7,4,5,6,5,3,1}, 4)){
			System.out.print(i + " ");
		}
		
		System.out.println();
		for(int i : addOne(new int[]{9,8})){
			System.out.print(i + " ");
		}
		
		System.out.println(checkrangeEnd(new int[]{3,3,1,0,2,0,1}));
		String test = "total";
		findRepeatWithHT(test);
		findRepeatWithArray(test);
		String str = "Battle of the Vowels: Hawaii vs. Grozny", remove="aeiou";
		System.out.println(removeChars(str, remove));
		
	}
	
	private static int[] evenOdd(int[] array){
		int evenIndex = 0, oddIndex = array.length - 1;
		while(evenIndex < oddIndex){
			if(array[evenIndex] % 2 == 0){
				evenIndex++;
			}else{
				int temp = array[evenIndex];
				array[evenIndex] = array[oddIndex];
				array[oddIndex--] = temp;
			}
		}
		return array;
	}

	private static int[] dutchFlagPartition(int[] array, int pivotIndex){
		int lessIndex = 0, moreIndex = array.length, equalIndex = 0;
		while(equalIndex < moreIndex){
			if(array[equalIndex] < array[pivotIndex]){
				int temp = array[lessIndex];
				array[lessIndex++] = array[equalIndex];
				array[equalIndex++] = temp;
			}
			else if(array[equalIndex] == array[pivotIndex]){
				equalIndex++;
			}
			else {
				int temp = array[equalIndex];
				array[equalIndex] = array[--moreIndex];
				array[moreIndex] = temp;
			}
		}
		return array;
	}
	
	private static int[] addOne(int[] array){
		int carry = 0, i = array.length - 1;
		array[i] = array[i] + 1;
		while(i >= 0) {
			if(array[i] + carry >= 10){
				array[i] = array[i] + carry - 10;
				carry = 1;
			}else{
				array[i] = array[i] + carry;
				carry = 0;
			}
			i--;
		} 
		if(carry == 1){
			int[] newArray = new int[array.length + 1];
			newArray[0] = carry;
			for(int j = 1; j < newArray.length - 1; j++){
				newArray[j] = array[j];
			}
			array = newArray;
		}
		return array;
	}
	
	private static boolean checkrangeEnd(int[] array){
		int range = 0, reach = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] > range){
				range = range + array[i] - 1;
				reach += range;
			}
			if(reach >= array.length - 1){
				return true;
			}
			range--;
		}
		return false;
	}
	
	static void findRepeatWithHT(String str){
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>(); 
		for(char c : arr){
			if(hm.containsKey(c)){
				int newCount = hm.get(c);
				hm.put(c, newCount + 1);
			}else{
				hm.put(c,1);
			}
		}
		for(char c : arr){
			if(hm.get(c)==1){
				System.out.println(c);
				break;
			}
		}
	}
	
	static void findRepeatWithArray(String str){
		char[] arr = str.toCharArray();
		int[] freq = new int[128];
		for(int i=0;i<arr.length;i++){
			freq[(int)arr[i]] +=1;
		}
		for(int i=0;i<arr.length;i++){
			if(freq[arr[i]]==1){
				System.out.println((char)arr[i]);
				break;
			}
		}
	}
	
	static String removeChars( String str, String remove ){
		char[] strArr =  str.toCharArray();
		char[] remArr = remove.toCharArray();
		int i=0;
		boolean[] charMap = new boolean[128];
		for(char c : remArr){
			charMap[c] = true;
		}
		for(char c: strArr){
			if(!charMap[c]){
				strArr[i++] = c;
			}
		}
		return new String(strArr, 0, i);
	}
}
