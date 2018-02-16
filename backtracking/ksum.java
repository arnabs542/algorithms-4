package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ksum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        kSum(result, new ArrayList<Integer>(), nums, target, 4, 0, nums.length-1);
        return result;
    }

    /* generic function for kSum, iterative */
    private void kSum(List<List<Integer>> result,List<Integer> cur,int[] nums, int target,int k,int start, int end){
        // k == 0 or other cases
        if (k == 0 || nums.length == 0 || start > end) return;
        else if (k == 1) { // 1 sum
            for (int num : nums) {
                if (num == target) {
                    cur.add(num);
                    result.add(new ArrayList<>(cur));
                    cur.remove(num);
                }
            }
        } else if (k == 2) {// two sum
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    cur.add(nums[start]);
                    cur.add(nums[end]);
                    result.add(new ArrayList<>(cur));
                    cur.remove(cur.size()-1);
                    cur.remove(cur.size()-1);

                    // avoid duplicates
                    while (start < end && nums[start] == nums[start+1]) start++;
                    while (start < end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                } else if (sum < target) {
                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) start++;
                    start++;
                } else {
                    while(start < end && nums[end] == nums[end-1]) end--;
                    end--;
                }
            }
        } else { // k sum
            // avoid unnecessary cases
            if (k * nums[start] > target || k * nums[end] < target) return;
            // k > 2 : iteratively do (k-1) sum for nums[start] to nums[end-k+1]
            for (int i = start; i <= end-k+1; i++) {
                // avoid duplicates
                if (i > start && nums[i] == nums[i-1]) continue;
                if (k * nums[i] <= target) {
                    cur.add(nums[i]);
                    kSum(result, cur, nums, target - nums[i], k - 1, i + 1, end);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
