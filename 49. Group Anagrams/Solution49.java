import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class Solution49 {
    public static String[] readTheFile(String string) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(string));
        StringBuilder stringBuilder = new StringBuilder();
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            stringBuilder.append(new String(buffer));
            buffer = new char[10];
        }
        reader.close();

        String content = stringBuilder.toString();
        return content.split(",");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return new ArrayList<>(List.of(List.of(strs)));
        }
        HashMap<String, ArrayList<String>> finalList = new HashMap<>();
        for (String str : strs) {
            char[] sortedStrCh = str.toCharArray();
            Arrays.sort(sortedStrCh);
            String sorterdStr = new String(sortedStrCh);
            if (!finalList.containsKey(sorterdStr)) {
                finalList.put(sorterdStr, new ArrayList<String>(Arrays.asList(str)));
            } else {
                finalList.get(sorterdStr).add(str);
            }
        }
        return new ArrayList<List<String>>(finalList.values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));

        // try {
        //     String[] strs = readTheFile("49. Group Anagrams\test_case.txt");
        //     long start = System.currentTimeMillis();
        //     System.out.println(groupAnagrams(strs));
        //     long time = System.currentTimeMillis() - start;
        //     System.out.println(time / 1000.0);
        // } catch (IOException e) {
        //     System.out.println("FNF");
        // }
    }
}