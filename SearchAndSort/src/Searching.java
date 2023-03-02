import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * This class contains methods for searching through an Array using Binary and
 * Linear search.
 * 
 * @author Tahmid Khan Arnab
 * 
 */
public class Searching {
	// SecureRandom Object created to generated random integers
	private Random r = new SecureRandom();

	/**
	 * This method performs an recursive binary search using 4 parameters.
	 * 
	 * @param array An Array that the method will search through
	 * @param first The index of the first element in the Array
	 * @param last  The index of the last element in the Array
	 * @param index The number whose index is to be searched for
	 * @return Returns the index of the number if it is in the Array, otherwise
	 *         returns -1
	 */
	public int recursiveBinarySearch(int array[], int first, int last, int index) {
		// Middle index
		int middle = (first + last) / 2;
		// If last goes below first, the whole Array has been searched and the number
		// has not been found
		if (last < first) {
			return -1;
		}
		// If the middle most number is less than the number being searched for, calls
		// the method with the
		// right half of the Array
		if (array[middle] < index) {
			return recursiveBinarySearch(array, middle + 1, last, index);
		}
		// If the middle most number is more than the number being searched for, calls
		// the method with the
		// left half of the Array
		if (array[middle] > index) {
			return recursiveBinarySearch(array, first, middle - 1, index);
		}
		// If the middle most number is equal to the number, returns the middle most
		// number
		if (array[middle] == index) {
			return middle;
		}
		// If the number is not found, returns -1
		return -1;
	}

	/**
	 * This method performs an recursive linear search using 3 parameters
	 * 
	 * @param array An Array that the method will search through
	 * @param size  The size of the Array
	 * @param index The number whose index is to be searched for
	 * @return Returns the index of the number if it is in the Array, otherwise
	 *         returns -1
	 */
	public int recursiveLinearSearch(int[] array, int size, int index) {
		// Decreases size each time the method is called
		size--;
		if (size < 0) { // If size goes below zero, the number has not been found
			return -1;
		}
		// If the right-most value is the number being searched for, returns that number
		if (array[size] == index) {
			return size;
			// Else calls the method again with the now decremented size
		} else {
			return recursiveLinearSearch(array, size, index);
		}
	}

	/**
	 * This method initializes an Array of 1000 integers with random values from
	 * 120-1000 exclusive using the SecureRandom class
	 * 
	 * @return The Array that has been initialized
	 */
	public int[] generateRandomInts() {
		// The Array to be returned, with a size of 1000
		int[] array = new int[1000];
		// For loop that populates the Array using random values
		for (int i = 0; i < 1000; i++) {
			int max = 999;
			int min = 121;
			array[i] = r.nextInt(max - min + 1) + min;
		}
		// Prints the generated Array to the console
		System.out.println("Array of randomly generated integers:\n" + Arrays.toString(array));
		return array;
	}
}
