package revision;

import java.util.Scanner;

public class StaticMethodExamples {

    /*
        CREATING A STATIC METHOD
        Syntax:
            public static returnType methodName(Parameter information){
                // Code to be run
            }
        Note 1: If the method should return something, returnType should be set to that
        Note 2: If the method should NOT return anything, returnType should be set to void
     */

    /**
     * Displays all data in a supplied int array in an indexed list
     * (the index used is the position within the array, starting at 0)
     * @param data The array to be printed to the console
     */
    public static void printArray(int [] data){
        System.out.println("--------------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d: %d\n", i, data[i]);
        }
        System.out.println("--------------------------------");
    }

    /**
     * Creates a duplicate array containing the elements from a supplied source array.
     *
     * @param source The array of ints to be duplicated.
     * @return  An int array containing the same elements as the supplied source array,
     * in the same order, or null if the source array was null.
     */
    public static int[] copyArray(int [] source){
        // Validate the incoming data - make sure the array exists before copying it!
        if(source != null)
        {
            // Make a new array the same size as the source
            int [] duplicateArray = new int[source.length];
            for (int i = 0; i < source.length; i++) {
                duplicateArray[i] = source[i];
            }
            return duplicateArray;
        }else{
            // If the source array doesn't exist, return null
            return null;
        }
    }
    public static void main(String[] args) {
        // Set up scanner to allow user input
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");

        // Ask user to specify size of array
        System.out.println("Please enter the size you need the array to be:");
        int size = input.nextInt();
        // Create an array of appropriate size and fill it with 5s
        int [] data = new int[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = 5;
        }

        /*
            USING A STATIC METHOD:
            Syntax:
                methodName(parameters); (where nothing is returned)
            or
                variable = methodName(parameters); (where something is returned)
        */
        // Call the non-returning method to print the array
        printArray(data);

        // Call the returning method to make a duplicate array
        int [] duplicate = copyArray(data);
        // Call the non-returning method to print the array
        printArray(duplicate);
    }
}
