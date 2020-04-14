import java.util.Arrays;

/*
	Sort Algorithms comparison: 
	1. Complete the generateRandomArray() method so it returns a random array that matches
	   the parameter values.
	* For #2, #3, #4 type/write out a small report on a separate sheet of paper 
	2. Time each sort algorithm for 1000, 10000, 100000 element arrays.  Which is the fastest 
       for each of these array lengths?  (You can turn off printing)
	3. Identify which algorithm matches each of the four sorts below.  Show which part of the code
	   for each algorithm matches the description given here.
		a. Insertion Sort: moves the value at the current index as far left as it can go, and 
		   places the current value at the location where all elements to the left are less than
		   this value.
		b. Merge Sort: splits the input array in half, and calls Merge Sort on each half.  Then,
		   recombines each half in sorted order.
		c. Selection Sort: finds the smallest value, and puts it at index 0.  Finds the next
		   smallest value, and puts it at index 1.  Finds the next smallest value, and puts it
		   at index 2 and so forth.
		d. Bubble Sort: At the first pass, the largest value will bubble to the end of the array.
           On the second pass, the second largest value will bubble to the second to last index
		   in the array, and so forth.
	4. Write out each of the steps each of the algorithms below will take to sort {3, 4, 2, 6, 1, 5}
	   For instance: step 1: {3, 2, 4, 1, 5, 6}, step 2: {2, 3, 1, 4, 5, 6} but also show which 
	   swaps or movements occurs.
*/
public class SortAlgorithms {

  public static void main(String[] args) {

    int[] unsortedArray = generateRandomArray(10, 1, 10);
	System.out.println(Arrays.toString(unsortedArray));
	long start1 = System.nanoTime();
    int[] sorted1 = sort1(Arrays.copyOf(unsortedArray, unsortedArray.length));
	double elapsed1 = (System.nanoTime() - start1)/1000000.0;
	System.out.println(elapsed1 + "ms: " + Arrays.toString(sorted1));
	
	long start2 = System.nanoTime();
	double elapsed2 = (System.nanoTime() - start2)/1000000.0;
    int[] sorted2 = sort2(Arrays.copyOf(unsortedArray, unsortedArray.length));
	System.out.println(elapsed2 + "ms: " + Arrays.toString(sorted2));
	//System.out.println(Arrays.toString(sorted2));

	long start3 = System.nanoTime();
	double elapsed3 = (System.nanoTime() - start3)/1000000.0;
	int[] sorted3 = sort3(Arrays.copyOf(unsortedArray, unsortedArray.length));
	System.out.println(elapsed3 + "ms: " + Arrays.toString(sorted3));
	//System.out.println(Arrays.toString(sorted3));

	long start4 = System.nanoTime();
	double elapsed4 = (System.nanoTime() - start4)/1000000.0;
	int[] sorted4 = sort4(Arrays.copyOf(unsortedArray, unsortedArray.length));
	System.out.println(elapsed4 + "ms: " + Arrays.toString(sorted4));
	//System.out.println(Arrays.toString(sorted4));
	
  }


  public static int[] generateRandomArray(int numNumbers, int minVal, int maxVal) {
	int[] arr = new int[numNumbers];
	int val = minVal;
	for (int i = 0; i < arr.length; i++) {
		arr[i] = val;
		val++;
	}
	arr = shuffle(arr);
    return arr;
  }
  
  public static int[] shuffle(int[] input) {
	  for (int i = 0; i < input.length; i++) {
			int pickSpotA = (int)(Math.random()*input.length);
			int pickSpotB = (int)(Math.random()*input.length);
			while (pickSpotA == pickSpotB) {
				pickSpotB = (int)(Math.random()*input.length);
			}
			int tmp = input[pickSpotA];
			input[pickSpotA] = input[pickSpotB];
			input[pickSpotB] = tmp;
	  }
	  return input;
  }

  public static int[] sort1(int[] inputArr) {
	for (int i = 0; i < inputArr.length; i++) {
		for (int j = 0; j < inputArr.length - 1 - i; j++) {
			if (inputArr[j] > inputArr[j+1]) {
				int temp = inputArr[j];
				inputArr[j] = inputArr[j+1];
				inputArr[j+1] = temp;
			}
		}
	}
	return inputArr;
  }

  public static int[] sort2(int[] inputArr) {
	for (int i = 0; i < inputArr.length; i++) {
		int val = inputArr[i];
		int valIndex = i;
		for (int j = i+1; j < inputArr.length; j++) {
			if (inputArr[j] < val) {
				val = inputArr[j];
				valIndex = j;
			}
		}
		inputArr[valIndex] = inputArr[i];
		inputArr[i] = val;
	}
	return inputArr;
  }

  public static int[] sort3(int[] inputArr) {
	for (int i = 1; i < inputArr.length; i++) {
		int val = inputArr[i];
		int j = i;
		while (j > 0 && val < inputArr[j-1]) {
			inputArr[j] = inputArr[j-1];
			j--;
		}
		inputArr[j] = val;
	}
	return inputArr;
  }

  public static int[] sort4(int[] inputArr) {
	if (inputArr.length == 1)
		return inputArr;
  
	int[] firstHalf = new int[inputArr.length/2 + inputArr.length%2];
	int[] secondHalf = new int[inputArr.length/2];
	for (int i = 0; i < inputArr.length; i++) {
		if (i < firstHalf.length)
			firstHalf[i] = inputArr[i];
		else
			secondHalf[i - firstHalf.length] = inputArr[i];
	}
	
	firstHalf = sort4(firstHalf);
	secondHalf = sort4(secondHalf);
	
	int[] sortedArr = new int[firstHalf.length + secondHalf.length];
	int firstIndex = 0;
	int secondIndex = 0;
	for (int i = 0; i < sortedArr.length; i++) {
		boolean chooseFirst = false;
		boolean chooseSecond = false;
		
		if (firstIndex >= firstHalf.length)
			chooseSecond = true;
		else if (secondIndex >= secondHalf.length)
			chooseFirst = true;
		else if (firstHalf[firstIndex] < secondHalf[secondIndex])
			chooseFirst = true;
		else
			chooseSecond = true;
		
		if (chooseFirst) {
			sortedArr[i] = firstHalf[firstIndex];
			firstIndex++;
		}
		else {
			sortedArr[i] = secondHalf[secondIndex];
			secondIndex++;
		}
	}
	
	return sortedArr;
  }


}
