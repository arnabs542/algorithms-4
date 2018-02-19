/*
*
* 169. Majority Element
* https://leetcode.com/problems/majority-element/description/
* ----------------------------------------------------------------------------------------------------------------------
* Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
* You may assume that the array is non-empty and the majority element always exist in the array.
*
* */

package array;

import java.util.HashMap;
import java.util.Map;

public class majority_element {
    /*---------Method 1: Map--------------*/
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mid = nums.length / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > mid) return num;
        }
        return 0;
    }

    /*---------Method 2: majority vote algorithm--------------*/
    public static int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else count--;
        }
        return major;
    }

    /*---------Method 3: bit manipulation--------------*/
    public int majorityElement3(int[] nums) {
        int[] bit = new int[32];
        for (int num: nums)
            for (int i=0; i<32; i++)
                if ((num>>(31-i) & 1) == 1)
                    bit[i]++;
        int ret=0;
        for (int i=0; i<32; i++) {
            bit[i]=bit[i]>nums.length/2?1:0;
            ret += bit[i]*(1<<(31-i));
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        System.out.println(majorityElement2(nums));
    }
}
