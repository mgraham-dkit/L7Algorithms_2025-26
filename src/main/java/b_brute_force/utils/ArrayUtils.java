package b_brute_force.utils;

public class ArrayUtils {
    /**
     * Returns the smallest integer found in the supplied array.
     * @param nums The array of integers to be searched.
     * @return The smallest integer found within the array.
     * @throws IllegalArgumentException where the supplied array is null or empty
     */
    public static int findMin(int [] nums){
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("Cannot find minimum value in a null or empty array");
        }

        // SETUP
        int currentMin = Integer.MAX_VALUE;

        // LOGIC
        // FOR EACH ELEMENT IN ARRAY
        for (int i = 0; i < nums.length; i++) {
            // IF current element is less than minimum value
            if(nums[i] < currentMin){
                // SET minimum value to current element
                currentMin = nums[i];
            }
        }

        // OUTPUT
        return currentMin;
    }
}
