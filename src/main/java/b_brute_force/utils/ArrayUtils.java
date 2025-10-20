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

    public int set(int [] data, int value, int index){
        // VALIDATION
        if(data == null){
            throw new IllegalArgumentException("Array to be edited cannot be null");
        }

        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Index is outside the boundaries of the supplied array");
        }

        // SETUP
        int original = data[index];

        // LOGIC
        data[index] = value;

        // OUTPUT
        return original;
    }

    public int insert(int [] data, int value, int index){
        // VALIDATION
        if(data == null){
            throw new IllegalArgumentException("Array to be edited cannot be null");
        }

        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Index is outside the boundaries of the supplied array");
        }

        // SETUP
        int original = data[data.length-1];

        // LOGIC
        for (int i = data.length-1; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;

        // OUTPUT
        return original;
    }
}
