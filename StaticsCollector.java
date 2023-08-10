package hw5_ver1;
import java.io.*; 
import java.util.*; 

public class StaticsCollector {
	static int countQuick=0; 
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("src/hw5_ver1/input.txt")); 
		PrintWriter output = new PrintWriter(new File("src/hw5_ver1/output.txt")); 
		int[] original, sorted; 
		
		while(input.hasNext()) {
			original = read(input, output); 
			sorted = printBubble(output, original);
			countQuick = 0; 
			sorted = printQuick(output, original);
			sorted = printShell(output, original); 
			output.print("\n\n\n\n"); 
		}
		
		output.close();
		input.close();
	}
	public static int[] read(Scanner input, PrintWriter output) {
		String header = input.nextLine();
		output.println(header); 
		int size = readSize(header); 
		String line = input.nextLine(); 
		int[] arr = readArr(line, size); 
		output.println("Original Group: "); 
		printArr(output, arr); 
		
		return arr; 
	}
	public static int readSize(String source) {
		Scanner line = new Scanner(source); 
		String type = line.next(); 
		int size = line.nextInt(); 
		return size; 
	}
	public static int[] readArr(String source, int n){
		Scanner line = new Scanner(source); 
		int[] arr = new int[n]; 
		for(int i=0; i<n; i++) {
			arr[i] = line.nextInt(); 
		}
		return arr; 
	}
	public static void printArr(PrintWriter output, int[] arr) {
		for(int print : arr) {
			output.print(print + " "); 
		}
		output.println(); 
	}
	public static void printCounter(PrintWriter output, String name, int count){
		output.println(name + ", took " + count + " passes. "); 
	}
	public static int[] copyArr(int[] original){
		int[] arr = new int[original.length];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = original[i]; 
		}
		return arr; 
	}
	
	public static int[] printBubble(PrintWriter output, int[] original) {
		int[] arr = copyArr(original);
		output.print("Array is sorted by : ");
		int[] sorted = bubbleSort(output, arr);
		output.println("This is the sorted array: "); 
		printArr(output, sorted); 
		
		return sorted; 
	}
	public static int[] printQuick(PrintWriter output, int[] original) {
		int[] arr = copyArr(original);
		output.print("Array is sorted by: ");
		quickSort(output, arr, 0, arr.length-1);
		int[] sorted = arr; 
		printCounter(output, "Quick Sort", countQuick); 
		output.println("This is the sorted array: "); 
		printArr(output, sorted); 
		
		return sorted; 
	}
	public static int[] printShell(PrintWriter output, int[] original) {
		int[] arr = original; 
		output.print("Array is sorted by : ");
		int[] sorted = shellSort(output, arr);
		output.println("This is the sorted array: "); 
		printArr(output, sorted); 
		
		return sorted; 
	}
	
	
	public static int[] bubbleSort(PrintWriter output, int[] arr) {
		 int n = arr.length;
		 int count = 0; 
		 for (int i = 0; i < n - 1; i++) {
			 for (int j = 0; j < n - i - 1; j++) {
				 count++; 
				 if (arr[j] > arr[j + 1]) {
					 int temp = arr[j];
					 arr[j] = arr[j + 1];
					 arr[j + 1] = temp;
				 }
			 }
		 }
		 printCounter(output, "Bubble Sort", count); 
		 return arr; 
	}
	
	
	public static int[] shellSort(PrintWriter output, int arr[]) {
	    int n = arr.length;
	    int count = 0; 

	    for (int gap = n / 2; gap > 0; gap /= 2) {
	        for (int i = gap; i < n; i++) {
	            int key = arr[i];
	            int j = i;
	            count ++; 
	            while (j >= gap && arr[j - gap] > key) {
	                arr[j] = arr[j - gap];
	                j -= gap;
	                
	            }
	            arr[j] = key;
	        }
	    }
	    
	    printCounter(output, "Shell Sort", count); 
	    return arr; 
	}
	
	public static void quickSort(PrintWriter output, int[] arr, int low, int high) {
		countQuick++; 
		//check for empty or null array
		if (arr == null || arr.length == 0){
			return;
	    }
	     
	    if (low >= high){
	    	return;
	    }
	 
	    //Get the pivot element from the middle of the list
	    int middle = low + (high - low) / 2;
	    int pivot = arr[middle];
	 
	    // make left < pivot and right > pivot
	    int i = low, j = high;
	    while (i <= j) {
	      //Check until all values on left side array are lower than pivot
	      while (arr[i] < pivot) 
	      {
	        i++;
	      }
	      //Check until all values on left side array are greater than pivot
	      while (arr[j] > pivot) 
	      {
	        j--;
	      }
	      //Now compare values from both side of lists to see if they need swapping 
	      //After swapping move the iterator on both lists
	      if (i <= j) 
	      {
	        swap (arr, i, j);
	        i++;
	        j--;
	      }
	    }
	    //Do same operation as above recursively to sort two sub arrays
	    if (low < j){
	      quickSort(output, arr, low, j);
	    }
	    if (high > i){
	      quickSort(output, arr, i, high);
	    }
	    
	  }
	   
	public static void swap (int[] array, int x, int y){
	    int temp = array[x];
	    array[x] = array[y];
	    array[y] = temp;
	    }
}
