package algos;

// T: O(1) S: O(N)

public class HashMap {
    private final Node[] bucket;
    private final int capacity;

    private static class Node {
        private int key, value;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashMap(int capacity) {
        this.capacity = capacity;
        bucket = new Node[capacity];
    }

    private int hash(int key) {
        return key % this.capacity;
    }

    public void put(int key, int value) {
        int idx = hash(key);
        Node head = bucket[idx];

        while(head != null) {
            if(head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        bucket[idx] = newNode;
    }

    public int get(int key) {
        int idx = hash(key);
        Node head = bucket[idx];
        while(head != null) {
            if(head.key == key) {
                return head.value;
            }
            head = head.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap(5);
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(4, 4);
        hashMap.put(5, 5);
        System.out.println(hashMap.get(3));
    }

}
