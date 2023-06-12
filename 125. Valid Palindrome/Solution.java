class Solution {
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();
        s = s.replaceAll("[^\\w+]|_", "");
        for (int i=0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() -1 -i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "ab_a";
        // String s = "ab_a";
        System.out.println(isPalindrome(s));
    }
}
