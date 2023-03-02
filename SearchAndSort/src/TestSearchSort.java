import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains the main method.
 * 
 * @author Tahmid Khan Arnab
 */
public class TestSearchSort {
	/**
	 * This is the main method, it has a menu system that allows the user to perform
	 * searches on an Array along with a subMenu that calls methods from another
	 * class to sort the Array with different algorithms
	 * 
	 * @see Searching
	 * @see SortingAlgorithms
	 * @param args Args
	 */
	public static void main(String[] args) {
		// True if the Array has been made, false otherwise, used in the menu
		boolean isArray = false;
		// Scanner to be used to get user input
		Scanner input = new Scanner(System.in);
		// Option that the user enters
		int option = 0;
		// The number the user wants to search for
		int number = 0;
		// Used to measure time in nanoseconds
		long nano = 0;
		// Used to measure time in milliseconds
		long milli = 0;
		// Error message if the Array is not created
		String error = "\nError: please initialize an Array first.\n";
		// New SortingAlgorithms instance to use it's methods
		SortingAlgorithms sort = new SortingAlgorithms();
		// New Searching instance to use it's methods
		Searching search = new Searching();
		// TestSearchSort instance to print menu
		TestSearchSort test = new TestSearchSort();
		// Main Array
		int[] array = new int[1000];
		// Temporary Array to pass to sorting methods
		int[] tempArray = new int[1000];
		// Do loop that simulates a menu system and runs until the user enters 5 to exit
		do {
			// True if the user enters an integer, false otherwise, used for exception
			// handling and letting the user type values even after exceptions occur using
			// do while loops around try catch statements
			boolean isInteger = false;
			test.displayMenu();
			// Do while loop that runs till the user enters valid input
			do {
				System.out.print(">");
				// Try statement in case of Scanner errors
				try {
					option = input.nextInt();
					// Sets isInteger to true if no errors are caused
					isInteger = true;

				} catch (java.util.InputMismatchException e) {
					// Sets isInteger to false so the loop can run again
					isInteger = false;
					// Error message if user doesn't enter an integer
					System.out.println("\nPlease enter an integer. ");
					// Clearing the Scanner buffer
					input.nextLine();
				}
			} while (!isInteger);
			isInteger = false;
			// Switch for menu system with appropriate methods for their options
			switch (option) {
			// Assigns an Array of random integers to the main Array, array
			case 1:
				array = search.generateRandomInts();
				// Sets isArray to true, as the Array has been made
				isArray = true;
				break;
			case 2:
				// Prints an error if the Array has not been made, otherwise performs the action
				if (!isArray) {
					System.out.println(error);
				} else {
					// Same do while loop from main menu that runs until user enters an integer
					do {
						System.out.println("Please enter an integer to search for: ");
						// Try statement in case of Scanner errors
						try {
							number = input.nextInt();
							// Sets isInteger to true if no errors are caused
							isInteger = true;
						} catch (java.util.InputMismatchException e) {
							// Sets isInteger to false so the loop can run again
							isInteger = false;
							// Error message if user doesn't enter an integer
							System.out.println("Error: enter an integer ");
							// Clearing the Scanner buffer
							input.nextLine();
						}
					} while (!isInteger);
					isInteger = false;
					// Passes the number, Array and other parameters to the proper methods
					System.out.println("Recursive binary search: ");
					// Makes tempArray a copy of array, so that array is never changed/sorted
					System.arraycopy(array, 0, tempArray, 0, 1000);
					sort.BubbleSort(tempArray);
					nano = System.nanoTime();
					milli = System.currentTimeMillis();
					int result = search.recursiveBinarySearch(tempArray, 0, 999, number);
					long timeNano = System.nanoTime() - nano;
					long timeMilli = System.currentTimeMillis() - milli;
					System.out.println(Arrays.toString(array));
					// Depending on if the number has been found or not, prints a report with the
					// time taken
					if (result == -1) {
						System.out.println(number + " was not found.");
						System.out.println("\nTime taken in nanoseconds: " + timeNano);
						System.out.println("Time taken in milliseconds: " + timeMilli);
						System.out.println();
					} else {
						int position = search.recursiveLinearSearch(array, 1000, number);
						System.out.printf("%d was found at index %d\n", number, position);
						System.out.println("\nTime taken in nanoseconds: " + timeNano);
						System.out.println("Time taken in milliseconds: " + timeMilli);
						System.out.println();
					}
				}
				break;
			case 3:
				// If Array has not been created, prints an error message
				if (!isArray) {
					System.out.println(error);
				} else {
					do {
						System.out.println("Please enter an integer to search for: ");
						// Try statement in case of Scanner errors
						try {
							number = input.nextInt();
							// Sets isInteger to true if no errors are caused
							isInteger = true;
						} catch (java.util.InputMismatchException e) {
							// Sets isInteger to false so the loop can run again
							isInteger = false;
							// Error message if user doesn't enter an integer
							System.out.println("\nError: enter an integer ");
							// Clearing the Scanner buffer
							input.nextLine();
						}
					} while (!isInteger);
					isInteger = false;
					// Passes the number, Array and other parameters to the proper methods
					System.out.println("Recursive linear search: ");
					nano = System.nanoTime();
					milli = System.currentTimeMillis();
					int result = search.recursiveLinearSearch(array, 1000, number);
					long timeNano = System.nanoTime() - nano;
					long timeMilli = System.currentTimeMillis() - milli;
					System.out.println(Arrays.toString(array));
					// Depending on whether or not the number has been found, prints an appropriate
					// report
					if (result == -1) {
						System.out.println(number + " was not found.");
						System.out.println("\nTime taken in nanoseconds: " + timeNano);
						System.out.println("Time taken in milliseconds: " + timeMilli);
						System.out.println();
					} else {
						System.out.printf("%d was found at index %d\n", number, result);
						System.out.println("\nTime taken in nanoseconds: " + timeNano);
						System.out.println("Time taken in milliseconds: " + timeMilli);
						System.out.println();
					}
				}
				break;
			case 4:
				if (!isArray) {
					System.out.println(error);
				} else {
					// Used for subMenu options
					String sortType;
					do {
						test.subMenu();
						boolean isValid = true;
						input.nextLine();
						// Makes tempArray a copy of array, so that array is never changed/sorted
						System.arraycopy(array, 0, tempArray, 0, 1000);
						// Loops the user until they choose a proper sorting algorithm
						do {
							if (!isValid) {
								System.out.println("Please choose either B, I, S, M, Q or R");
							}
							sortType = input.next();
							isValid = (sortType.equals("B") || sortType.equals("I") || sortType.equals("S")
									|| sortType.equals("M") || sortType.equals("Q") || sortType.equals("R"));
						} while (!isValid);
						// Switch with cases for each sorting algorithm, each one prints a report, with
						// the time taken, sorted array and unsorted array
						switch (sortType) {
						case "B":
							nano = System.nanoTime();
							milli = System.currentTimeMillis();
							sort.BubbleSort(tempArray);
							System.out.println(Arrays.toString(array));
							System.out.println("\nBubble Sort: Simple sorting algorithm O(n2) Complexity, In-place - ");
							System.out.println("\nSorted: " + Arrays.toString(tempArray));
							System.out.println("\nTime taken in nanoseconds: " + (System.nanoTime() - nano));
							System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - milli));
							System.out.println();
							break;
						case "I":
							nano = System.nanoTime();
							milli = System.currentTimeMillis();
							sort.InsertionSort(tempArray);
							System.out.println(Arrays.toString(array));
							System.out.println(
									"\nInsertion Sort: Simple sorting algorithm, O(n2) Complexity, In-place - ");
							System.out.println("\nSorted: " + Arrays.toString(tempArray));
							System.out.println("\nTime taken in nanoseconds: " + (System.nanoTime() - nano));
							System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - milli));
							System.out.println();
							break;

						case "S":
							nano = System.nanoTime();
							milli = System.currentTimeMillis();
							sort.SelectionSort(tempArray);
							System.out.println(Arrays.toString(array));
							System.out.println(
									"\nSelection Sort: Simple sorting algorithm O(n2) Complexity, In-place - ");
							System.out.println("\nSorted: " + Arrays.toString(tempArray));
							System.out.println("\nTime taken in nanoseconds: " + (System.nanoTime() - nano));
							System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - milli));
							System.out.println();
							break;

						case "M":
							nano = System.nanoTime();
							milli = System.currentTimeMillis();
							sort.MergeSort(tempArray);
							System.out.println(Arrays.toString(array));
							System.out.println(
									"\nMerge Sort: Recursive Divide-And-Conquer O(n log n) Complexity, Not in-place - ");
							System.out.println("\nSorted: " + Arrays.toString(tempArray));
							System.out.println("\nTime taken in nanoseconds: " + (System.nanoTime() - nano));
							System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - milli));
							System.out.println();
							break;

						case "Q":
							nano = System.nanoTime();
							milli = System.currentTimeMillis();
							sort.QuickSort(tempArray, 0, 999);
							System.out.println(Arrays.toString(array));
							System.out.println(
									"\nQuick Sort: Recursive Divide-And-Conquer O(n log n) Complexity, Not in-place - ");
							System.out.println("\nSorted: " + Arrays.toString(tempArray));
							System.out.println("\nTime taken in nanoseconds: " + (System.nanoTime() - nano));
							System.out.println("Time taken in milliseconds: " + (System.currentTimeMillis() - milli));
							System.out.println();
							break;
						// If user enters R, prints an appropriate message
						case "R":
							System.out.println("Returning to main menu...");
							sortType = "R";
							break;
						}
					} while (sortType != "R");
				}
				break;
			// If the user choose option 5, prints an exit message
			case 5:
				System.out.println("Exiting...\nProgram by Tahmid Khan Arnab");
				break;
			// If the user enters an invalid option, prints an error message
			default:
				System.out.println("Please choose an option between 1-5.");
				break;
			}
		} while (option != 5);
		// Close Scanner to prevent resource leak
		input.close();

	}

	/**
	 * Method for printing a menu for the user
	 */
	private void displayMenu() {
		System.out.println("Select your option in the menu:");
		System.out.println("1. Initialize and populate an Array of 1000 random integers");
		System.out.println("2. Perform recursive binary search");
		System.out.println("3. Perform recursive linear search");
		System.out.println("4. Sort the array");
		System.out.println("5. Quit");
	}

	/**
	 * Method for printing a subMenu
	 */
	private void subMenu() {
		System.out.println("Select a sorting algorithm:");
		System.out.println("B. Bubble sort");
		System.out.println("I. Insertion sort");
		System.out.println("S. Selection sort");
		System.out.println("M. Merge sort");
		System.out.println("Q. Quick sort");
		System.out.println("R. Return to main menu");
		System.out.print(">");
	}
}
