package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/lru-cache/description/

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3

Explanation: https://youtu.be/GsY6y0iPaHw?feature=shared

SC - O(n) TC - O(1)
 */

public class LRU {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    LRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node newNode) {
        Node temp = head.next;

        head.next = newNode;
        newNode.prev = head;

        newNode.next = temp;
        temp.prev = newNode;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            int val = node.value;

            map.remove(key);
            removeNode(node);

            addNode(node);
            map.put(key, head.next);

            return val;
        }

        return -1;
    }

    void put(int key, int val) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            removeNode(node);
        }

        if(map.size() == this.capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        addNode(new Node(key, val));
        map.put(key, head.next);
    }
}
