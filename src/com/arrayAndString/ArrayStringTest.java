package com.arrayAndString;

public class ArrayStringTest {

	public static void main(String[] args) {
		for(int i : evenOdd(new int[]{1,2,3,4,5,6,7,8,9})){
			System.out.print(i + " ");
		}
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

}
