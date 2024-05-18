import java.util.*;

class Solution973 {
    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(k, (a, b) -> Integer.compare(dist(b), dist(a)));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        while (!pq.isEmpty() && k > 0) {
            ans[--k] = pq.poll();
        }
        return ans;
    }

    private static int dist(int[] p) {
        return (p[0] * p[0]) + (p[1] * p[1]);
    }

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(kClosest(points, k)));

    }
}
