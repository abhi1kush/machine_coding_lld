package main.abhishek.datastructure;

public class DoubleLinkedList<ValueType> {
    private ListNode<ValueType> head;
    private ListNode<ValueType> lastNode;

    public DoubleLinkedList() {
        head = null;
        lastNode = null;
    }

    public ListNode<ValueType> getHead() {
        return head;
    }

    public ListNode<ValueType> getLastNode() {
        return lastNode;
    }

    public void addLast(ListNode<ValueType> node){
        if (lastNode == null) {
            head = node;
            lastNode = node;
        } else {
            lastNode.setNext(node);
            lastNode = node;
        }
    }

    public ListNode<ValueType> addLast(ValueType value) {
        if (lastNode == null) {
            ListNode<ValueType> newNode = new ListNode<ValueType>(value);
            head = newNode;
            lastNode = newNode;
        } else {
            ListNode<ValueType> newNode = new ListNode<ValueType>(value, lastNode, null);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        return lastNode;
    }

    public void remove(ListNode<ValueType> node) {
        if (node == null) {
            return;
        }

        // single node in list.
        if (node.getPrev() == null && node.getNext() == null) {
            head = null;
            lastNode = null;
        }

        //first node
        if (node.getPrev() == null) {
            head = head.getNext();
            node.setNext(null);
        }

        //last node
        if (node.getNext() == null) {
            lastNode = lastNode.getPrev();
            node.setPrev(null);
        }

        //middle
        ListNode<ValueType> prevNode = node.getPrev();
        ListNode<ValueType> nextNode = node.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
        node.setPrev(null);
        node.setNext(null);
    }

    public void removeFirst() {
        remove(head);
    }
}
