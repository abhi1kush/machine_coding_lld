package main.abhishek.cache.policies;

import main.abhishek.datastructure.DoubleLinkedList;
import main.abhishek.datastructure.ListNode;

import java.util.HashMap;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{
    private final HashMap<Key, ListNode<Key>> hMap;
    private final DoubleLinkedList<Key> dll;

    public LRUEvictionPolicy() {
        hMap = new HashMap<Key, ListNode<Key>>();
        dll = new DoubleLinkedList<Key>();
    }

    public void keyAccessed(Key key) {
        if (!hMap.containsKey(key)) {
            ListNode<Key> newNode = dll.addLast(key);
            hMap.put(key, newNode);
        } else {
            ListNode<Key> node = hMap.get(key);
            dll.remove(node);
            dll.addLast(node);
        }
    }

    public Key getEvictKey() {
        ListNode<Key> head = dll.getHead();
        if (head == null) {
            return null;
        }

        return head.getNodeValue();
    }
}
