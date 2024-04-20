class Solution746 {
    public static int minCostClimbingStairs(int[] cost) {
        int one = cost[0];
        int two = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = two;
            two = cost[i] + (Math.min(two, one));
            one = temp;
        }
        return Math.min(two, one);
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
