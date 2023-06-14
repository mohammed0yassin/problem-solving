import java.util.HashMap;

class Solution242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i=0; i < s.length(); i++) {
          freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) +1);
          freq.put(t.charAt(i), freq.getOrDefault(t.charAt(i), 0) -1);
        }
        for (Integer f : freq.values()) {
            if (f != 0) {
                return false;
            }
        }
     return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
