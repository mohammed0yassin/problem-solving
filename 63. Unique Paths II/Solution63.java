class Solution63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) break;
                if (i == 0 || j == 0) {
                    cache[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cache[i][j] = 0;
                    continue;
                }
                int left = cache[i][j - 1];
                int up = cache[i - 1][j];
                cache[i][j] = up + left;
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
        int[][] obstacleGrid = new int[][]{{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
