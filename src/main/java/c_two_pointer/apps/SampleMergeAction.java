package c_two_pointer.apps;

import c_two_pointer.utils.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SampleMergeAction {
    public static void main(String[] args) {
        int [] nums1 = ArrayUtils.generateRandomArray(10);
        int [] nums2 = ArrayUtils.generateRandomArray(5);


        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println("Nums1: " + ArrayUtils.toString(nums1));
        System.out.println("Nums2: " + ArrayUtils.toString(nums2));
        int [] combined = ArrayUtils.orderedMerge(nums1, nums2);

        System.out.println("Combined: " + ArrayUtils.toString(combined));
    }

}
