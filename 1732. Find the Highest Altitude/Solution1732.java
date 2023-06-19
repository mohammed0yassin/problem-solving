class Solution1732 {
    public static int largestAltitude(int[] gain) {
        int maxAlt = 0;
        int currentAlt = 0;
        for (int g : gain) {
            currentAlt += g;
            if (currentAlt > maxAlt) maxAlt = currentAlt;
        }
        return maxAlt;
    }
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
}
