class Solution125 {
//    public static boolean isPalindrome(String s) {
//        if (s.length() <= 1) {
//            return true;
//        }
//        s = s.toLowerCase();
//        s = s.replaceAll("[^\\w+]|_", "");
//        for (int i=0; i < s.length()/2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() -1 -i)) {
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "ab_a";
        // String s = "0P";
        System.out.println(isPalindrome(s));
    }
}
