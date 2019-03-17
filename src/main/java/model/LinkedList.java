package model;

public class LinkedList {

    private int data;
    private LinkedList next;

    public LinkedList(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList clone(){
        LinkedList clone = new LinkedList(this.data);
        if(this.next != null){
            clone.setNext(this.next.clone());
        }

        return clone;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        LinkedList temp = this;
        while (temp != null){
            sb.append(temp.data).append(" ");
            temp = temp.getNext();
        }

        return sb.toString();
    }
}
