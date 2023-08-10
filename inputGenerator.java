package hw5_ver1;
import java.util.*; 
import java.io.*; 

public class inputGenerator {
	public static void main(String[] args) throws IOException{
		PrintWriter output = new PrintWriter(new File("src/hw5_ver1/input.txt")); 
		
		
		output.println("1.	10 numbers in almost sorted order (a few out of order)"); 
		printAlmostSorted(output, 10);
		output.println("2.	10 numbers in random order"); 
		printRandom(output, 10);
		output.println("3.	10 numbers in reverse order (a few out of order)"); 
		printAlmostReverse(output, 10);
		output.println("4.	30 numbers in almost sorted order (a few out of order)"); 
		printAlmostSorted(output, 30);
		output.println("5.	30 numbers in random order"); 
		printRandom(output, 30);
		output.println("6.	30 numbers in reverse order (a few out of order)"); 
		printAlmostReverse(output, 30);
		output.println("7.	50 numbers in almost sorted order (a few out of order)"); 
		printAlmostSorted(output, 50);
		output.println("8.	50 numbers in random order"); 
		printRandom(output, 50);
		output.println("9.	50 numbers in reverse order (or almost reverse)"); 
		printAlmostReverse(output, 50);
		
		output.close();
		
		
	}
	
	public static Boolean isDuplicate(int[] arr, int test) {
		for(int i = 0; i<arr.length ;i++) {
			if(arr[i] == test) {
				return true; 
			}
		}
		return false; 
	}
	public static int randomInt() {
		return (int)(Math.random()*(100-(-100)+1))+(-100);
	}
	public static void printArr(PrintWriter output, int[] arr) {
		for(int print : arr) {
			output.print(print + " "); 
		}
		output.println();
	}
	public static int[] adjustOrder(int[] arr, int n) {
		int nFixed = (int)(Math.random()*(n/8-n/10+1))+n/10; 
		
		for(int i=0; i<nFixed; i++) {
			int pos = (int)(Math.random()*(n-1+1)); 
			int insert = randomInt(); 
			while(isDuplicate(arr, insert)) {
				insert = randomInt(); 
			}
			arr[pos] = insert; 
		}
		return arr; 
	}
	
	public static void printAlmostSorted(PrintWriter output, int n) {
		int[] arr = createSorted(n); 
		arr =  adjustOrder(arr, n);
		printArr(output, arr); 
		
	}
	public static int[] createSorted(int n) {
		int[] arr = new int[n];
		int start = (int)(Math.random()*(30-(-100)+1))+(-100);
		arr[0] = start; 
		for(int i=1; i<n; i++) {
			arr[i] = arr[i-1] + (int)(Math.random()*(8-1+1)+1); 
		}
		return arr; 	
	}

	
	public static void printAlmostReverse(PrintWriter output, int n) {
		int[] arr = createReverse(n); 
		arr =  adjustOrder(arr, n);
		printArr(output, arr); 
	}
	public static int[] createReverse(int n) {
		int[] arr = new int[n];
		int start = (int)(Math.random()*(100-(-20)+1))+(-20); 
		arr[0] = start;
		for(int i=1; i<n; i++) {
			arr[i] = arr[i-1] - (int)(Math.random()*(8-1+1)+1); 
		}
		return arr; 	
	}
	
	public static void printRandom(PrintWriter output, int n) {
		int[] arr = createRandom(n); 
		printArr(output, arr); 
	}
	public static int[] createRandom(int n) {
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			int insert = randomInt(); 
			while(isDuplicate(arr, insert)) {
				insert = randomInt(); 
			}
			arr[i] = insert; 
		}
		return arr; 
	}
}
