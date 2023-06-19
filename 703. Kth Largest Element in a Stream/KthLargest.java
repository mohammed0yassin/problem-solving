import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int queueSize;
    
    public KthLargest(int k, int[] nums) {
        this.queueSize = k;
        for (int n : nums) {
            this.queue.add(n);
        }
        while (queue.size() > k){
            this.queue.remove();
        }
        
    }
    
    public int add(int val) {
        this.queue.add(val);
        while(this.queue.size() > this.queueSize) {
            this.queue.remove();
        }
        return this.queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargest kth = new KthLargest(k,nums);
        System.out.println(kth);
        System.out.println(kth.add(-3));
        System.out.println(kth.add(-2));
        System.out.println(kth.add(-4));
        System.out.println(kth.add(0));
        System.out.println(kth.add(4));
    }
}
