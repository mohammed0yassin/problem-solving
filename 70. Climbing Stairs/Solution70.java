class Solution70 {
    public static int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for (int i = 0; i < n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return two;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }
}
