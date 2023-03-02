/**
 * This class contains methods to perform different types of sorting on Arrays.
 * 
 * @author Tahmid Khan Arnab
 */
public class SortingAlgorithms {
	/**
	 * This method performs a bubble sort on an Array
	 * 
	 * @param array Array to be sorted
	 */
	public void BubbleSort(int[] array) {
		int n = array.length;
		// For swapping
		int temp = 0;
		// For loop that goes through all elements of Array
		for (int i = 0; i < n; i++) {
			// For loop that compares adjacent elements and swaps if necessary
			for (int j = 1; j < (n - i); j++) {
				if (array[j - 1] > array[j]) {
					// Swap elements
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * This method performs an insertion sort on an Array
	 * 
	 * @param array Array to be sorted
	 */
	public void InsertionSort(int[] array) {
		int n = array.length;
		// For loop that goes through all elements in the Array
		for (int i = 1; i < n; i++) {
			// Sets array[i] element as the key
			int key = array[i];
			// Variable to track index of previous element
			int j = i - 1;
			// Compare key to previous values and swap as needed
			while (j >= 0 && array[j] > key) {
				// Shift previous element to right
				array[j + 1] = array[j];
				j--;
			}
			// Puts the key in it's correct position
			array[j + 1] = key;
		}
	}

	/**
	 * This method performs a selection sort on an Array
	 * 
	 * @param array Array to be sorted
	 */
	public void SelectionSort(int[] array) {
		int n = array.length;
		// For loop to go through all elements
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			// For loop to find lowest value in unsorted part of Array
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			// Swaps lowest value of unsorted Array as the last value in the sorted Array
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	/**
	 * This method performs a recursive merge sort on an Array
	 * 
	 * @param array Array to be sorted
	 */
	public void MergeSort(int[] array) {
		if (array.length > 1) {
			// Divide array to 2 parts
			int mid = array.length / 2;
			int[] leftArray = new int[mid];
			int[] rightArray = new int[array.length - mid];
			System.arraycopy(array, 0, leftArray, 0, leftArray.length);
			System.arraycopy(array, mid, rightArray, 0, rightArray.length);
			// Recursively sort both left and right Arrays
			MergeSort(leftArray);
			MergeSort(rightArray);
			int i = 0;
			int j = 0;
			int k = 0;
			while (i < leftArray.length && j < rightArray.length) {
				if (leftArray[i] <= rightArray[j]) {
					array[k++] = leftArray[i++]; // Copy left value to the original array
				} else {
					array[k++] = rightArray[j++]; // Copy right value to the original array
				}
			}
			while (i < leftArray.length) {
				array[k++] = leftArray[i++]; // Copy remaining values from left half
			}
			while (j < rightArray.length) {
				array[k++] = rightArray[j++]; // Copy remaining values from right half
			}
		}
	}

	/**
	 * This method performs a Quick Sort on an Array using a private helper method
	 * 
	 * @param array Array to be sorted
	 * @param left  The index of the left most value. used to create sub-Arrays
	 * @param right The index of the right most value, used to create sub-Arrays
	 * @see SortingAlgorithms#swap(int[], int, int)
	 */
	public void QuickSort(int[] array, int left, int right) {
		if (left < right) { // Base case, checks if sub-Array has more than one element
			int pivotIndex = left + (right - left) / 2; // Choose the index of the pivot
			int pivotValue = array[pivotIndex]; // The value at the pivot
			int i = left;
			int j = right;
			// Partition Array into two sub-Arrays, less than and greater than the pivot
			while (i <= j) {
				// Move i forward till it reaches a value that is greater than or equal to the
				// pivot
				while (array[i] < pivotValue) {
					i++;
				}
				// Move j backward till it reaches a value that is less than or equal to the
				// pivot
				while (array[j] > pivotValue) {
					j--;
				}
				// If i is less than or equal to j, it means that array[i] is greater than
				// pivotValue and array[j] is less than pivotValue. Therefore, we swap them.
				if (i <= j) {
					swap(array, i, j);
					i++;
					j--;
				}
			}
			// Recursively sort left and right sub-Arrays
			QuickSort(array, left, j);
			QuickSort(array, i, right);
		}
	}

	/**
	 * This method swaps two values in an Array
	 * 
	 * @param array Array whose values will be swapped
	 * @param i     first index to be swapped
	 * @param j     second index to be swapped with
	 */
	private void swap(int[] array, int i, int j) {
		// Temporary variable for swapping
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
