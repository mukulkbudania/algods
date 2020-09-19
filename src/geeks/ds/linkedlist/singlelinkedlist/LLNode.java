package geeks.ds.linkedlist.singlelinkedlist;

/**
 * Created by mukulbudania on 7/18/17.
 */
public class LLNode {
    private int data;
    private LLNode next;

    public LLNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
