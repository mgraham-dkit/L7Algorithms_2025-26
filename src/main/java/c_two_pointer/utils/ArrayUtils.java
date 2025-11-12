package c_two_pointer.utils;

import java.util.Random;

public class ArrayUtils {
    public static int [] generateRandomArray(int numElements) {
        if(numElements < 1){
            throw new IllegalArgumentException("Number of elements to be generated must be >= 1");
        }

        Random randomGenerator = new Random();

        int [] nums = new int[numElements];
        for (int i = 0; i < nums.length-1; i++) {
            nums[i] = randomGenerator.nextInt(100);
        }

        return nums;
    }

    public static String toString(int [] nums){
        if(nums == null){
            throw new IllegalArgumentException("Cannot convert a null array to a String");
        }
        if(nums.length == 0){
            return "Array contains no elements";
        }
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < nums.length-1; i++){
            sb.append(nums[i]);
            sb.append(",");
        }

        sb.append(nums[nums.length-1]);
        sb.append("]");

        return sb.toString();
    }


}
