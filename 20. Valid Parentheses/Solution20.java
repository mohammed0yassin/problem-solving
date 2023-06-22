import java.util.HashMap;
import java.util.Stack;

class Solution20 {
    public static boolean isValid(String s) {
        HashMap<Character, Character> table = new HashMap<>();
        table.put('(', ')');
        table.put('{', '}');
        table.put('[', ']');

        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()) {
            if (table.get(c) != null) {
                chars.push(c);
            } else {
                if (chars.empty() || c != table.get(chars.peek())) {
                    return false;
                }
                chars.pop();
            }
        }
        return chars.empty();
    }

    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid(s));
    }
}
