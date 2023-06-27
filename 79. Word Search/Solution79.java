class Solution79 {

    public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board[0].length; cols++) {
                if (board[rows][cols] == word.charAt(0)) {
                    if (backtrack(rows, cols, 0, word, board)) return true;
                }
            }
        }
        return exist;
    }

    private static boolean backtrack(int rows, int cols, int index, String word, char[][] board) {
        boolean exist;
        if (index == word.length()) return true;
        if (rows < 0 || cols < 0 || rows >= board.length || cols >= board[0].length || word.charAt(index) != board[rows][cols])
            return false;
        char temp = board[rows][cols];
        board[rows][cols] = ' ';
        index += 1;
        exist = (backtrack(rows + 1, cols, index, word, board) ||
                backtrack(rows - 1, cols, index, word, board) ||
                backtrack(rows, cols + 1, index, word, board) ||
                backtrack(rows, cols - 1, index, word, board));
        board[rows][cols] = temp;
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        String word = "ABCB";
//        String word = "SEE";
//        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
//        String word = "AAB";
        System.out.println(exist(board, word));
    }
}