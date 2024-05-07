import java.util.LinkedList;
import java.util.Queue;

class Solution200 {

    public static int numIslands(char[][] grid) {
        int islands = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
//                // BFS
//                if (grid[r][c] == '1' && !seen[r][c]) {
//                    bfs(r, c, grid, seen);
//                    islands++;
//                }
                // DFS
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void bfs(int r, int c, char[][] grid, boolean[][] seen) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{r, c});
        seen[r][c] = true;
        while (!queue.isEmpty()) {
            Integer[] currentLocation = queue.poll();
            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                int currentRow = currentLocation[0] + dx;
                int currentCol = currentLocation[1] + dy;
                if (currentRow > seen.length - 1 || currentCol > seen[0].length - 1 || currentRow < 0 || currentCol < 0
                        || seen[currentRow][currentCol]) {
                    continue;
                }
                seen[currentRow][currentCol] = true;
                if (grid[currentRow][currentCol] == '1')
                    queue.add(new Integer[]{currentRow, currentCol});
            }
        }
    }

    private static void dfs(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        grid[r][c] = '0';
        for (int[] direction : directions) {
            int dx = direction[0];
            int dy = direction[1];
            dfs(r + dx, c + dy, grid);
        }

//        // a little bit faster DFS
//        grid[r][c] = '0';
//        dfs(r + 1, c , grid);
//        dfs(r - 1, c, grid);
//        dfs(r, c + 1, grid);
//        dfs(r, c - 1, grid);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
