class DoublyLinkedList {
    Integer key;
    Integer val;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList() {
        this.key = null;
        this.val = null;
        this.next = null;
        this.prev = null;
    }

    public DoublyLinkedList(Integer key, Integer val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}
