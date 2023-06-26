import java.util.ArrayList;
import java.util.List;

class Solution22 {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, n, 0, 0);
        return ans;
    }

    private static void backtrack(ArrayList<String> current, ArrayList<String> ans, int n, int openCount, int closedCount) {
        if (current.size() == 2*n) {
            ans.add(String.join("", current));
        }
            if (openCount < n) {
                current.add("(");
                openCount += 1;
                backtrack(current, ans, n, openCount, closedCount);
                current.remove(current.size() - 1);
                openCount -= 1;
            }

            if (closedCount < openCount) {
                current.add(")");
                closedCount += 1;
                backtrack(current, ans, n, openCount, closedCount);
                current.remove(current.size() - 1);
            }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
