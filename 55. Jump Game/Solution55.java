class Solution55 {
    //Greedy O(n)
    public static boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }
//    Using DP O(n^2)
//    public static boolean canJump(int[] nums) {
//        long[] dp = new long[nums.length];
//        dp[nums.length - 1] = 1;
//        for (int i = nums.length - 2; i >= 0; i--) {
//            if (i == 66) {
//                System.out.println("HERE");
//            }
//            for (int j = 0; j <= nums[i]; j++) {
//                if (j  == 29) {
//                    System.out.println("HERE");
//                }
//                if (i + j > nums.length - 1) continue;
//                dp[i] += dp[i + j];
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(dp));
//        return dp[0] >= 1;
//    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
}
