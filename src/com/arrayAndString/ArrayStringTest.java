package com.arrayAndString;

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
}
