package revision;

import java.util.Scanner;

public class UserInputExamples {
    public static void main(String[] args) {
        /*
            Examples of working with user input
        */
        // SETTING UP THE SCANNER:
        // Create a scanner to access the user input & set it up appropriately
        Scanner input = new Scanner(System.in);
        // Set the delimiter - this will read in the full line instead of up to the first space (allowing you to have
        // many words in one entry and not miss what the user enters!)
        // This will also avoid input "skipping" if the user enters more than one word in an answer
        input.useDelimiter("\n");

        // USING THE SCANNER:
        // Prompt the user to enter information - prompts should be INFORMATIVE
        System.out.println("Please enter your first name:");
        // Use next() or nextLine() to read in text
        String fName = input.next();
        System.out.println("Please enter your last name");
        String lName = input.next();
        System.out.println("Please enter your age:");
        // Use nextInt() or nextDouble() to read in numbers.
        int age = input.nextInt();

        // OUTPUTTING TO THE USER:
        // You can display your information using print(), println() or printf()
        System.out.print("Using print() will _not_ start a new line after the message displays! ");
        System.out.println("Using println() _will_ start a new line after the message displays.");
        System.out.printf("This will let you insert variable data into the line without using +. For example: \n");
        System.out.printf("Hi %s %s, aged %d.", fName, lName, age);
    }
}