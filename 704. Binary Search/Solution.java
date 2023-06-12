class Solution {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            // mid = left + ((right - left) / 2); //for very large nums
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(search(nums, target));
    }
}
