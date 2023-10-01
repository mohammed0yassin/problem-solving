import java.util.Arrays;

class Solution1493 {
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int longestSubarray = 0;
        int numZeros = 0;
        while (left <= right && right < nums.length) {
            int tmpLongest = 0;
            while (numZeros <= 1 && right < nums.length) {
                if (nums[right] == 1) {
                    tmpLongest = right - left + 1 - numZeros;
                    if (right == 0)
                        tmpLongest = 1;
                    if (tmpLongest > longestSubarray)
                        longestSubarray = tmpLongest;
                }
                else if (nums[right] == 0) {
                    numZeros++;
                }
                right++;
            }
            if(nums[left] == 0)
                numZeros = 1;
            left++;
        }
        if (numZeros == 0)
            longestSubarray-=1;
        return longestSubarray;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,0,0};
        System.out.println(longestSubarray(nums));
    }
}