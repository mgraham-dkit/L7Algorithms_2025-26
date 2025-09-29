package a_revision.exercises;

import java.util.Scanner;

public class CalcMax {
    public static int getValidInteger(String prompt){
        /*
Uses this text as prompt to the user.
•
Confirms the data being entered is a number.
o
If the data is a number, it should be stored.
o
If it is not a number, the user should be informed their entered information was inappropriate, then prompted to enter a value again (using the same text as before).
o
The value entered should be confirmed as a number. If it is not, this process should repeat.
•
Returns the entered (and validated) number
         */
        Scanner input = new Scanner(System.in);
        int num = 0;

        boolean valid = false;
        while(!valid) {
            System.out.println(prompt);
            if (input.hasNextInt()) {
                num = input.nextInt();
                valid = true;
            }else{
                System.out.println("Please enter an integer!");
                input.nextLine();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(getValidInteger("Please enter a number:"));
    }
}
