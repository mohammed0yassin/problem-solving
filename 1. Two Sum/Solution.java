import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numAndIndex = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (numAndIndex.containsKey(target - nums[i])) {
                return new int[] {numAndIndex.get(target - nums[i]), i};
            }
            numAndIndex.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target= 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
