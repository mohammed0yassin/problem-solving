import java.util.*;

class Solution621 {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        Queue<Integer> pq = new PriorityQueue<>();
        Queue<int[]> taskQueue = new LinkedList<>();
        for (char c : tasks) {
            freq[c - 65]++;
        }
        for (int j : freq) {
            if (j == 0) continue;
            pq.add(-j); //Max Heap
        }
        int time = 0;
        while (!taskQueue.isEmpty() || !pq.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int nextTask = pq.poll() + 1;
                if (nextTask < 0) taskQueue.add(new int[]{nextTask, time + n});
            }
            if (!taskQueue.isEmpty() && taskQueue.peek()[1] == time) {
                int currentTask = taskQueue.poll()[0];
                if (currentTask < 0) pq.add(currentTask);
            }
        }
        return Math.max(time, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
}
