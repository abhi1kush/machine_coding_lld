package main.abhishek.datastructure;

public class ListNode<ValueType> {
    private ValueType nodeValue;
    private ListNode<ValueType> prev;
    private ListNode<ValueType> next;

    public ListNode(ValueType nodeValue) {
        this.nodeValue = nodeValue;
        this.prev = null;
        this.next = null;
    }

    public ListNode(ValueType nodeValue, ListNode<ValueType> prev, ListNode<ValueType> next) {
        this.nodeValue = nodeValue;
        this.prev = prev;
        this.next = next;
    }

    public ValueType getNodeValue() {
        return nodeValue;
    }

    public ListNode<ValueType> getPrev() {
        return prev;
    }

    public ListNode<ValueType> getNext() {
        return next;
    }

    public void setPrev(ListNode<ValueType> prev) {
        this.prev = prev;
    }

    public void setNext(ListNode<ValueType> next) {
        this.next = next;
    }
}
