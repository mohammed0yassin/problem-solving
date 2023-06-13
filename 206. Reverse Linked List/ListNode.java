import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printAllList(ListNode head) {
        ArrayList<Integer> allList = new ArrayList<>();
        allList.add(head.val);
        while (head.next != null) {
            allList.add(head.next.val);
            head = head.next;
        }
        System.out.println(allList);
    }

    public static void main(String[] args) {
        ListNode fifth = new ListNode(5, null);
        ListNode forth = new ListNode(4, fifth);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(1, second);
        printAllList(head);

    }
}
