import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution347 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        Arrays.stream(nums).forEach(x -> map.put(x , map.computeIfAbsent(x, s -> Integer.valueOf(0)) + Integer.valueOf(1)));
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> {
                    int result = - Integer.compare(Math.abs(v1), Math.abs(v2));
                    if (result == 0) {
                        result = - Integer.compare(v1, v2);
                    }
                    return result;
                }))
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));        

        int[] result = sortedMap.keySet().stream().limit(k).mapToInt(i -> i).toArray();
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {1,1,1,2,2,3};
        int[] nums = {4,1,-1,2,-1,2,3};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}


// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // build map<num, frequence>
//         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for (int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
//         // sort list from map.keyset() by map.get(num),
//         List<Integer> list = new ArrayList<>(map.keySet());
//         Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
//         // transfer results from list to int[];
//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) res[i] = list.get(i);
        
//         return res;
//     }
// }