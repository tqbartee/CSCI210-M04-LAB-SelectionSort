package edu.desu.sortsearchutils;

import java.util.Scanner;
import static edu.desu.helperstaticmethods.HelperStaticMethods.generateScrambledIntArray;

/**
 * Description of what this utility class does.
 * Follows Effective Java item 4: Enforce noninstantiability with a private constructor.
 */
public final class SelectionSort {

    // 1. Private constructor prevents instantiation from within and outside the class
    private SelectionSort() {
        throw new AssertionError("Utility class cannot be instantiated");
    }

    // 2. Static Utility Methods here; can duplicate
    // Perform selection sort on an array of int
    public static void selectionSort(int[] data) {

        // Throws NullPointerException immediately if data is null, matching Arrays.sort()
        if (data == null) {
            throw new NullPointerException("The input array cannot be null");
        }

        // //TODO: Implement selection sort core logic here

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1. Ask the user to input an integer for array size or 'Q' to quit.
            System.out.print("Enter array size (or 'Q' to quit): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("Q")) {
                break;
            }

            int arraySize = Integer.parseInt(input.replace(",", ""));

            // 2. Generate a scrambled array of integers of array size using generateScrambledIntArray.
            int[] data = generateScrambledIntArray(arraySize);

            // 3. Set a timestamp for the start of a timing test using the java current time in nanoseconds.
            long startTime = System.nanoTime();

            // 4. Run selectionSort on the array.
            selectionSort(data);

            // 5. Set a second timestamp for the end of the timing test using the java current time in nanoseconds.
            long endTime = System.nanoTime();

            // 6. Subtract the first time in nanoseconds from the second time.
            long elapsedTime = endTime - startTime;

            // 7. Print "Time to complete selectionSort call: " and then the number of nanoseconds to run selectionSort.
            System.out.println("Time to complete selectionSort call: " + elapsedTime + " nanoseconds");

            // 8. Compute and print time in seconds in human readable decimal format (avoiding scientific notation)
            double elapsedTimeInSeconds = (double) elapsedTime / 1_000_000_000.0;
            System.out.println("Time to complete selectionSort call in seconds: " + String.format("%.9f", elapsedTimeInSeconds) + " seconds");
        }

        scanner.close();
    }
}
