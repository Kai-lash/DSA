package com.arrayAndString;

import java.util.Arrays;
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
		System.out.println(reverseWord(str));
		System.out.println(toInt("-567"));
		System.out.println(isUnique("Kailash"));
		System.out.println(isPermute("abc", "bca"));
		System.out.println(URLify("Mr John Smith    ", 13));
		System.out.println(checkPermutePalin("kabab"));
		System.out.println(checkOneEditAway("pale","ples"));
		String testInp = "aabcccccaaa";
		String compString = getCompressedString(testInp);
		System.out.println(compString.length() > testInp.length() ? testInp:compString);
		rotateMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 4);
		zeroMatrix(new int[][]{{0,2,3},{4,5,6},{7,8,9}});
		
		System.out.println();
		for(int i : deleteDuplicates(new int[]{1,1,1,2})){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(computeMaxProfit(new int[]{310,315,275,295,260,270,290,230,255,250}));
		System.out.println(computeMaxProfitBuySellTwice(new int[]{12,11,13,9,12,8,14,13,15}));
		
		System.out.println();
		for(int i : generatePrime(11)){
			System.out.print(i + " ");
		}
		System.out.println();
		for(char i : applyPermutation(new int[]{3,2,1,0}, new char[]{'a','b','c','d'})){
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : randomSampling(new int[]{1,2,3,4,5,6,7,8,9,0}, 3)){
			System.out.print(i + " ");
		}
		System.out.println(reverseVowels("hello"));
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
	
	static String reverseWord(String str){
		char[] strArr = str.toCharArray();
		String word = "", rev = "";
		for(char c: strArr){
			word += c;
			if(c == ' '){
				rev = word + rev;
				word = "";
			}
		}
		return word + " " + rev;
	}
	
	static int toInt(String str){
		char[] strArr = str.toCharArray();
		boolean isNegative = false;
		int number=0;
		for(char c : strArr){
			if(c == '-'){
				isNegative =  true;
			}else{
				number = (c - '0') + number*10;
			}
		}
		if(isNegative){
			return -number;
		}else{
			return number;
		}
	}
	
	private static boolean isUnique(String s){
		boolean[] map = new boolean[256];
		for(char c : s.toCharArray()){
			if(map[(int)c]){
				return false;
			}
			map[(int)c] = true;
		}
		return true;
	}
	
	private static boolean isPermute(String s1, String s2){
		boolean[] map = new boolean[256];
		if(s1.length() != s2.length()){
			return false;
		}else{
			for(char c : s1.toCharArray()){
				map[(int)c] = true;
			}
			for(char c : s2.toCharArray()){
				if(!map[(int)c]){
					return false;
				}
			}
			return true;
		}
	}
	
	private static char[] URLify(String s, int trueCount){
		int spaceCount = 0;
		char[] URL = s.toCharArray();
		for(int i = 0; i < trueCount; i++){
			if(URL[i] == ' '){
				spaceCount++;
			}
		}
		int index = trueCount + 2*spaceCount;
		for(int i = trueCount - 1; i >= 0; i--){
			if(URL[i] == ' '){
				URL[index - 1] = '0';
				URL[index - 2] = '2';
				URL[index - 3] = '%';
				index -= 3;
			}else{
				URL[index - 1] = URL[i];
				index--;
			}
		}
		return URL;
	}
	
	private static boolean checkPermutePalin(String s){
		int[] map = new int[256];
		int oddCharCount = 0;
		for(char c : s.toCharArray()){
			map[(int)c] = map[(int)c] + 1;
		}
		for(int i = 0; i < map.length; i++){
			if(map[i]>0 && map[i]%2!=0){
				oddCharCount++;
			}
		}
		if(oddCharCount > 1){
			return false;
		}
		return true;
	}
	
	private static boolean checkOneEditAway(String s1, String s2){
		int index1 = 0, index2 = 0, edits = 0;
		if(s2.length() > s1.length()){
			String temp = s2;
			s2 = s1;
			s1 = temp;
		}
		while(index1 < s1.length() && index2 < s2.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				edits++;
				if(s1.length() != s2.length()){
					index1++;
				}
			}
			index1++;
			index2++;
		}
		return edits>1?false:true;
	}
	
	private static String getCompressedString(String s){
		int charCount = 1;
		StringBuilder compString = new StringBuilder();
		for(int i = 0, j = 1; i < s.toCharArray().length && j < s.toCharArray().length; i++, j++){
			if(s.charAt(i) == s.charAt(j)){
				charCount++;
			}
			if((s.charAt(i) != s.charAt(j)) || (i == s.toCharArray().length - 2)){
				compString.append(s.charAt(i));
				compString.append(charCount);
				charCount = 1;
			}
		}
		return compString.toString();
	}
	
	private static void rotateMatrix(int[][] matrix, int N){
		int[][] buffer =  new int[1][4];
		StringBuilder mat = new StringBuilder();
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				mat.append(matrix[i][j] + " ");
			}
			mat.append("\n");
		}
		System.out.println(mat);
		mat = new StringBuilder();
		
		for(int i = 0; i < N/2; i++){
			for(int j = i; j < N - i - 1; j++){
				buffer[0][j] = matrix[j][N-i-1];
				matrix[j][N-i-1] = matrix[i][j];
				matrix[i][j] = matrix[N-j-1][i];
				matrix[N-j-1][i] = matrix[N-i-1][N-j-1];
				matrix[N-i-1][N-j-1] = buffer[0][j];
			}
		}
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				mat.append(matrix[i][j] + " ");
			}
			mat.append("\n");
		}
		System.out.println(mat);
	}
	
	private static void zeroMatrix(int[][] matrix){
		StringBuilder mat = new StringBuilder();
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				mat.append(matrix[i][j] + " ");
			}
			mat.append("\n");
		}
		System.out.println(mat);
		mat = new StringBuilder();
		boolean[] zeroRows = new boolean[matrix.length];
		boolean[] zeroCols = new boolean[matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					zeroRows[i] = true;
					zeroCols[j] = true;
				}
			}
		}
		
		for(int i = 0; i < zeroRows.length; i++){
			if(zeroRows[i]){
				for(int j = 0; j < matrix[0].length; j++){
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < zeroCols.length; i++){
			if(zeroCols[i]){
				for(int j = 0; j < matrix.length; j++){
					matrix[j][i] = 0;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				mat.append(matrix[i][j] + " ");
			}
			mat.append("\n");
		}
		System.out.println(mat);
	}
	
	private static int[] deleteDuplicates(int[] array){
		int a = 0, b = 1;
		while(a < array.length && b < array.length ){
			if(array[a] >= array[b] && array[a]!=0){
				array[b] = 0;
			}else if(array[a+1] == 0) {
				array[a+1] = array[b];
				array[b] = 0;
				a++;
			}else{
				a++;
			}
			b++;
		}
		return array;
	}
	
	private static int computeMaxProfit(int[] array){
		int min = Integer.MAX_VALUE, profit = 0;
		for(int i = 0; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
			}
			if(profit < (array[i]-min)){
				profit = array[i]-min;
			}
		}
		return profit;
	}
	
	private static int computeMaxProfitBuySellTwice(int[] array){
		int min = Integer.MAX_VALUE, profit = 0, maxProfit = 0;
		int[] firstProfit = new int[array.length];
		for(int i = 0; i < array.length; i++){
			if(array[i] < min){
				min = array[i];
			}
			if(profit <= (array[i]-min)){
				profit = array[i]-min;
				firstProfit[i] = profit;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = array.length - 1; i > 0; i--){
			max = Math.max(max, array[i]);
			maxProfit = Math.max(maxProfit, max - array[i] + firstProfit[i-1]);
		}
		return maxProfit;
	}
	
	private static int[] generatePrime(int n){
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		int[] primes = new int[n+1];
		for(int i = 2; i <= n; i++){
			if(isPrime[i]){
				primes[i] = i;
			}
			for(int j = i; j <= n; j++){
				if(j%i == 0){
					isPrime[j] = false; 
				}
			}
		}
		return primes;
	}
	
	private static char[] applyPermutation(int[] perm, char[] array){
		char temp = ' ';
		for(int i = 0; i < array.length; i++){
			int next = i;
			while(perm[next] >=0){
				temp = array[perm[next]];
				array[perm[next]] = array[i];
				array[i] = temp;
				int a = perm[next];
				perm[next] = -1;
				next = a;
			}
		}
		return array;
	}
	
	private static int[] randomSampling(int[] array, int k){
		int temp = 0;
		for(int i = 0; i < k; i++){
			int n = (int)(Math.random()*10);
			temp = array[n];
			array[n] = array[i];
			array[i] = temp;
		}
		return array;
	}
	
	public static String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        char char1 = ' ', char2 = ' ';
        for(int i = 0, j = sb.length() - 1; i < j;){
        	boolean isVowel = true;
            char1 = sb.charAt(i);
            char2 = sb.charAt(j);
            if(!(char1 == 'a' || char1 == 'e' || char1 == 'i' || char1 == 'o' || char1 == 'u')){
            	i++;
            	isVowel = false;
            }
            if(!(char2 == 'a' || char2 == 'e' || char2 == 'i' || char2 == 'o' || char2 == 'u')){
            	j--;
            	isVowel = false;
            }
            if(isVowel){
            	sb.setCharAt(i, char2);
                sb.setCharAt(j, char1);
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}
