import java.util.ArrayList;
import java.util.List;

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return null;
    }

    public void backtrack(List<Integer> current, List<List<Integer>> ans, int[] nums) {
        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                backtrack(current, ans, nums);
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String[] args) {
    }
}
