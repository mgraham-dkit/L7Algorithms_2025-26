package c_two_pointer.apps;

import c_two_pointer.utils.ArrayUtils;

import java.util.Scanner;

public class SearchSortTestBed {
    public static void displayArray(int [] data){
        System.out.print("[");
        for (int i = 0; i < data.length-1; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println(data[data.length-1] + "]");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] data = {12, 34, 1, 4, 1234, -10, 38, 81, 2, 54, 23};
        System.out.print("Original array data: ");
        displayArray(data);

        ArrayUtils.bubbleSort(data);
        System.out.print("Sorted array data: ");
        displayArray(data);

        System.out.println("Now testing search functionality!");
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
