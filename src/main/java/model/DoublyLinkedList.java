package model;

public class DoublyLinkedList {

    private int data;
    private DoublyLinkedList prev;
    private DoublyLinkedList next;

    public DoublyLinkedList(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public DoublyLinkedList getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedList prev) {
        this.prev = prev;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList next) {
        this.next = next;
    }

    public DoublyLinkedList clone(){
        DoublyLinkedList clone = new DoublyLinkedList(this.data);

        if(this.prev != null){
            clone.setPrev(this.prev.clone());
        }

        if(this.next != null){
            clone.setNext(this.next.clone());
        }

        return clone;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        DoublyLinkedList temp = this;
        while (temp != null){
            sb.append(temp.data).append(" ");
            temp = temp.getNext();
        }

        return sb.toString();
    }
}
