import java.util.HashMap;
import java.util.Map;
public class LRUCache {
    int capacity;
    Map<Integer, DoublyLinkedList> dict = new HashMap<>();
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoublyLinkedList();
        this.tail = this.head;
    }

    public int get(int key) {
        if (!this.dict.containsKey(key)) {
            return -1;
        }
        DoublyLinkedList current = dict.get(key);
        this.delete(current);
        this.prepend(current);
        return dict.get(key).val;
    }

    public void put(int key, int value) {
        if (this.dict.containsKey(key)) {
            DoublyLinkedList oldNode = dict.get(key);
            this.delete(oldNode);
        }
        DoublyLinkedList node = new DoublyLinkedList(key, value);
        dict.put(key, node);
        this.prepend(node);
        this.evict();
    }

    private void prepend(DoublyLinkedList node) {
        this.head.prev = node;
        node.next = this.head;
        this.head = node;
        if (this.dict.size() == 1) {
            this.tail = this.head;
        }
    }

    private void delete(DoublyLinkedList node) {
        if (this.head == node) {
            this.head = this.head.next;
        }
        if (this.tail == node) {
            this.tail = this.tail.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

    private void evict() {
        if (this.dict.size() > this.capacity) {
            this.dict.remove(this.tail.key);
            this.delete(this.tail);
        }
    }
}