class Solution53 {
    public static int maxSubArray(int[] nums) {
        int left = 0;
        int right = 1;
        int maxSum = nums[0];
        int sum = nums[0];
        while (left <= right && right < nums.length) {
            if (sum <= 0 && nums[right] >= sum) {
                left = right;
                sum = nums[right];
            } else {
                sum += nums[right];
            }
            maxSum = Math.max(sum, maxSum);
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
