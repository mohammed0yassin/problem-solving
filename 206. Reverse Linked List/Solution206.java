class Solution206 {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode fifth  = new ListNode(5, null);
        ListNode forth  = new ListNode(4, fifth);
        ListNode third  = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode head   = new ListNode(1, second);
        ListNode.printAllList(reverseList(head));
    }
}
















// ListNode prev = null;  
// ListNode current = head;
// while(current != null) {
//     ListNode nxt = current.next;
//     current.next = prev;
//     prev = current;
//     current = nxt;
// }