package b_brute_force.utils;

public class ArrayUtils {
    public static int search(int [] data, int target){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        for (int i = 0; i < data.length; i++) {
            if(data[i] == target){
                return i;
            }
        }

        return -1;
    }

    public static int lastIndexOf(int [] data, int target){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        for (int i = data.length-1; i >= 0; i--) {
            if(data[i] == target){
                return i;
            }
        }

        return -1;
    }
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

    public static int delete(int [] data, int index){
        // VALIDATION
        if(data == null){
            throw new IllegalArgumentException("Array to be edited cannot be null");
        }

        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Index is outside the boundaries of the supplied array");
        }

        // SETUP
        int deleted = data[index];

        // LOGIC
        for (int i = index; i < data.length-1; i++) {
            data[i] = data[i+1];
        }

        data[data.length-1] = 0;

        // OUTPUT
        return deleted;
    }

    public static int [] merge(int [] nums1, int[] nums2){
        /*
            // VALIDATION:
            If nums1 is null or nums2 is null:
                throw new Illegal Argument Exception
        */
        if(nums1 == null || nums2 == null){
            throw new IllegalArgumentException("Cannot merge a null array");
        }
        /*
            // SET UP:
            Create a new array (merged) with size nums1.length + nums2.length
        */
        int [] merged = new int[nums1.length + nums2.length];

        /*
            // LOGIC:
            // Copy everything from first array to merged
            for each slot (i) in nums1:
                Save nums1[i] in merged[i]
        */
        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }
        /*
            for each slot (i) in nums2:
                Save nums2[i] in merged[nums1.length+i]
        */
        for (int i = 0; i < nums2.length; i++) {
            merged[nums1.length+i] = nums2[i];
        }

        /*
            // OUTPUT:
            return merged array
         */
        return merged;
    }

    public static int wipeAtIndex(int [] data, int index){
        // VALIDATION
        // REAL DATA CHECK
        if(data == null){
            throw new IllegalArgumentException("Cannot delete from a null array");
        }

        // GOOD DATA CHECK
        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Supplied position is outside boundaries of the supplied array");
        }

        // SETUP:
        int overwritten = data[index];

        // LOGIC:
        data[index] = 0;

        // OUTPUT:
        return overwritten;
    }

    public static boolean wipe(int [] data, int value){
        // VALIDATION
        // REAL DATA CHECK
        if(data == null){
            throw new IllegalArgumentException("Cannot delete from a null array");
        }

        // SETUP:
        boolean overwritten = false;

        // LOGIC:
        // for each position (i) in data:
        for (int i = 0; i < data.length; i++) {
            // if data[i] equals value:
            if(data[i] == value){
                // Set data[i] to 0 (overwrite it with a blank)
                data[i] = 0;
                // Set overwritten to true
                overwritten = true;
                // break out of loop
                break;
            }
        }

        // OUTPUT:
        return overwritten;
    }

    public static int wipeAll(int [] data, int value){
        // VALIDATION
        // REAL DATA CHECK
        if(data == null){
            throw new IllegalArgumentException("Cannot delete from a null array");
        }

        // SETUP:
        int overwrittenCount = 0;

        // LOGIC:
        // for each position (i) in data:
        for (int i = 0; i < data.length; i++) {
            // if data[i] equals value:
            if(data[i] == value){
                // Set data[i] to 0 (overwrite it with a blank)
                data[i] = 0;
                // Increase counter of how many have been overwritten
                overwrittenCount++;
            }
        }

        // OUTPUT:
        return overwrittenCount;
    }

}
