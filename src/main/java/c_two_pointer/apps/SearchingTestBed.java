package c_two_pointer.apps;

import c_two_pointer.utils.ArrayUtils;

import java.util.Scanner;

public class SearchingTestBed {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Please enter a value to search for: ");
        int target = input.nextInt();

        int index = ArrayUtils.binarySearch(data, target);
        if(index == -1){
            System.out.println(target + " was not found in the array");
        }else{
            System.out.println(target + " was found in the array at index " + index);
        }
    }
}
