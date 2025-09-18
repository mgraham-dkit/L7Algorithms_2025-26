package revision.exercises;

import java.util.Scanner;

public class SumAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = 0;
        int sum = 0;
        int count = 0;
        while(num != -1){
            System.out.println("Please enter a number (-1 to end):");
            num = input.nextInt();
            // sum = sum + num;
            sum += num;
            count++;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum/count));
    }
}

