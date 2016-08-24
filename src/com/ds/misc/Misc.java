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
		System.out.println(exponent(3, 4));
		System.out.println(reverseNumber(123));
		System.out.println(checkPalindrome(998));
		System.out.println(getRectIntesect(new Rectangle(1, 3, 3, 1), new Rectangle(2, 4, 1, 3)));
		
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
	
	private static int exponent(int x, int y){
		int result = 1;
		if(y < 0){
			x = 1/x;
		}
		while(y != 0){
			if((y & 1) == 1){
				result = result * x;
			}
			x = x * x;
			y = y >>> 1;
		}
		return result;
	}
	
	private static int reverseNumber(int number){
		boolean isNegative = number < 0 ? true : false;
		number = Math.abs(number);
		int newNumber = 0;
		while(number != 0){
			newNumber = (10 * newNumber) + (number % 10 );
			number /= 10;
		}
		return isNegative == true ? - newNumber : newNumber;
	}
	
	private static boolean checkPalindrome(int number){
		if(number < 0){
			return false;
		}
		int digits = 0, msb, lsb;
		while(number != 0){
			digits = (int)Math.log10(number) + 1;
			lsb = (int)number%10;
			msb = (int)(number/Math.pow(10, digits -1));
			if(msb == lsb){
				number -= (int)Math.pow(10, digits -1) * msb;
				number /= 10;
			}else{
				return false;
			}
		}
		return true;
	}
	
	private static Rectangle getRectIntesect(Rectangle r1, Rectangle r2){
		if(isRectIntersect(r1, r2)){
			return new Rectangle(Math.max(r1.x, r2.x), Math.min(r1.y, r2.y), 
					Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x), 
					Math.min(r1.y + r1.height, r2.y + r2.height) - Math.min(r1.y, r2.y));
		}else{
			return new Rectangle(0, 0, -1, -1);
		}
	}
	
	private static boolean isRectIntersect(Rectangle r1, Rectangle r2){
		return !(((r1.x + r1.width < r2.x) || (r2.x + r2.width < r1.x)) 
				|| ((r1.y - r1.height > r2.y) || (r1.y < r2.y - r2.height)));
	}
}

class Rectangle {
	int x, y, width, height;
	Rectangle(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	 
	public String toString(){
		return this.x + " " + this.y + " " + this.width + " " + this.height;
	}
}