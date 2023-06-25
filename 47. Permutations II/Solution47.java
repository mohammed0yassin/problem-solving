import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        calculateFrequency(freq, nums);
        backtrack(new ArrayList<>(), ans, nums, freq);
        return ans;
    }

    private static void calculateFrequency(HashMap<Integer, Integer> freq, int[] nums) {
        for (int num : nums) {
            if (!freq.containsKey(num)) {
                freq.put(num, 1);
            } else {
                freq.put(num, freq.get(num)+1);
            }
        }
    }

    private static void backtrack(List<Integer> current, List<List<Integer>> ans, int[] nums, HashMap<Integer, Integer> freq) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
        }

        for (int num : freq.keySet()) {
            if (!current.contains(num) || freq.get(num) > 0) {
                current.add(num);
                freq.put(num, freq.get(num) - 1);
                backtrack(current, ans, nums, freq);
                current.remove(current.size() - 1);
                freq.put(num, freq.get(num) + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        System.out.println(permuteUnique(nums));
    }
}
