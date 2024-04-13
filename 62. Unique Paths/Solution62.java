import java.util.Arrays;

class Solution62 {
    public static int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        Arrays.fill(cache[0], 1);
        for (int i = 0; i < m; i++) {
            cache[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cache[i][j] + " ");
            }
            System.out.println();
        }
        return cache[m - 1][n - 1];
    }


    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));
    }
}
