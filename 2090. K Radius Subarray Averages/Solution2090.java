import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Solution2090 {
    public static int[] readTheFile(String string) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        File file = new File(string);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] getAverages(int[] nums, int k) {
        int arrayLength = nums.length;
        if (arrayLength == 1 && k == 0) return nums;
        if (k==0) return nums;

        int[] kAvg = new int[arrayLength];
        Arrays.fill(kAvg,-1);
        long windowSum = 0;
        int windowLength = (2*k)+1;

        if (k>=arrayLength) return kAvg;
        if (arrayLength < windowLength) return kAvg;

        for(int i=0; i<windowLength;i++) {
            windowSum+=nums[i];
        }
        kAvg[k] = (int) (windowSum/windowLength);
        int counter = k+1;
        int start = 0;
        int last = windowLength;
        while(counter < arrayLength-k ) {
            windowSum  += (-nums[start] + nums[last]);
            kAvg[counter] = (int) (windowSum/windowLength);
            counter++;
            start++;
            last++;
        }
        return kAvg;
    }


    public static void main(String[] args) {
        int[] nums = {3,3};
        int k = 3;
//        int[] nums = {2,2,2,2,2,2,2,2};
//        int[] nums = {40527,53696,10730,66491,62141,83909,78635,18560};
//        int k = 2;
//        int[] nums = new int[0];
//        int k = 40000;
//        try {
//            nums = readTheFile("2090. K Radius Subarray Averages\\nums.txt");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }
}
