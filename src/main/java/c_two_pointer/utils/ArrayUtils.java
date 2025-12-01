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

    public static int [] orderedMerge(int [] nums1, int [] nums2){
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
            Create variable (nums1Tracker) to track number of elements used in nums1
            Create variable (nums2Tracker) to track number of elements used in nums2
        */
        int [] merged = new int [nums1.length + nums2.length];
        int nums1Tracker = 0;
        int nums2Tracker = 0;

        /*
            // LOGIC:
            for each slot (i) in merged:
                if nums1Tracker equals nums1.length:
                    Set merged[i] to current element in nums2
                    Increase nums2Tracker by 1
                else if nums2Tracker equals nums2.length:
                    Set merged[i] to current element in nums1
                    Increase nums1Tracker by 1
                else if current element in nums1 (nums1[nums1Tracker]) < current element in nums2 (nums2[nums2Tracker]):
                    Set merged[i] to current element in nums1
                    Increase nums1Tracker by 1
                else:
                    Set merged[i] to current element in nums2
                    Increase nums2Tracker by 1
        */
        for (int i = 0; i < merged.length; i++) {
            if(nums1Tracker == nums1.length){
                merged[i] = nums2[nums2Tracker];
                nums2Tracker++;
            }else if(nums2Tracker == nums2.length){
                merged[i] = nums1[nums1Tracker];
                nums1Tracker++;
            }else if(nums1[nums1Tracker] < nums2[nums2Tracker]){
                merged[i] = nums1[nums1Tracker];
                nums1Tracker++;
            }else{
                merged[i] = nums2[nums2Tracker];
                nums2Tracker++;
            }
        }
        /*
            // OUTPUT:
            return merged
         */
        return merged;
    }

    public int [] partition(int [] data, int pivot){
        if(data == null){
            throw new IllegalArgumentException("Array to be partitioned cannot be null");
        }

        int leftCount = 0;
        int rightCount = 0;
        for(int value: data){
            if(value <= pivot){
                leftCount++;
            }else{
                rightCount++;
            }
        }

        int [] left = new int[leftCount];
        int leftTracker = 0;
        int [] right = new int[rightCount];
        int rightTracker = 0;

        for(int value: data){
            if(value <= pivot){
                left[leftTracker] = value;
                leftTracker++;
            }else{
                right[rightTracker] = value;
                rightTracker++;
            }
        }

        int [] partitioned = merge(left, right);
        return partitioned;
    }

    public String [] deduplicate(String [] data){
        /*
            // VALIDATION
            if data is null:
                throw Illegal Argument Exception (cannot deduplicate a null array)
       */
        if(data == null){
            throw new IllegalArgumentException("Cannot deduplicate a null array");
        }

        if(data.length == 0){
            return new String [0];
        }

        /*
            // SETUP
            Create a new array (filtered) with size equal to data
            Create a variable (uniqueCount) to track number of elements added to filtered
        */

        String [] filtered = new String[data.length];
        int uniqueCount = 0;

        filtered[0] = data[0];
        uniqueCount++;

        /*
            // LOGIC
            for each element (elem) in data:
                Create boolean flag (found) to track if element exists in filtered and set to false
                for each slot (j) in filtered up to uniqueCount:
                    if elem equals value in filtered[j]:
                        Set found to true
                        Halt loop/break out of loop

                if found is false:
                    Set filtered[uniqueCount] to elem
                    Increase uniqueCount by 1
        */

        for (int i = 1; i < data.length; i++) {
            String currentElem = data[i];
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if(currentElem.equals(filtered[j])){
                    found = true;
                    break;
                }
            }
            if(!found){
                filtered[uniqueCount] = currentElem;
                uniqueCount++;
            }
            
        }
        /*
            resize filtered array to uniqueCount size and store in new array (resized)
        */
        String [] resized = new String[uniqueCount];
        for (int i = 0; i < resized.length; i++) {
            resized[i] = filtered[i];
        }
        /*
            // OUTPUT
            return resized
         */
        return resized;
    }

    public static int [] orderedDeduplicate(int [] data){
        // VALIDATION: Handle not real data
        if(data == null){
            throw new IllegalArgumentException("Cannot deduplicate a null array");
        }

        // Handle unsuitable data
        // If the array is empty, avoid any extra unnecessary processing
        if(data.length == 0){
            return new int[0];
        }

        // SETUP : Create an array to hold one copy of each value, plus a tracker to know where we are in it
        int [] filtered = new int[data.length];
        int uniqueCount = 0;

        // LOGIC
        // Add first element in automatically
        filtered[0] = data[0];
        uniqueCount++;

        // Loop through and add each of the rest in
        for(int i = 1; i < data.length; i++){
            // If the current element doesn't match the last thing we saved
            if(data[i] != filtered[uniqueCount-1]){
                // Save first instance of new value to filtered array
                filtered[uniqueCount] = data[i];
                // Increase number of values encountered
                uniqueCount++;
            }
        }

        // Filtered now contains only one copy of each value
        // If array is full, return it
        if(filtered.length == uniqueCount){
            return filtered;
        }

        // If array has empty slots, make a smaller one
        int [] resized = new int[uniqueCount];
        // Copy each value from the filtered array to the smaller array
        for (int i = 0; i < resized.length; i++) {
            resized[i] = filtered[i];
        }
        // Return the smaller array
        return resized;
    }

    public static int binarySearch(int [] data, int target){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        int start = 0;
        int end = data.length-1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(data[mid] == target){
                return mid;
            }else if(data[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void bubbleSort(int [] data){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        for (int passCount = 0; passCount < data.length-1; passCount++) {
            for (int j = 0; j < data.length - 1 - passCount; j++) {
                if(data[j] > data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }
}
