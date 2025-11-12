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
}
