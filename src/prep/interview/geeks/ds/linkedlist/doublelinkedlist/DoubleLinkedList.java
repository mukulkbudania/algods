package prep.interview.geeks.ds.linkedlist.doublelinkedlist;

import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LLNode;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class DoubleLinkedList {
    private DLLNode root;

    public DoubleLinkedList(){
        setRoot(null);
    }
    public DoubleLinkedList(int a[]){
        if(a.length>0){
            this.root = new DLLNode(a[0]);
            DLLNode node = root;
            for(int i=1;i<a.length;i++){
                DLLNode next=new DLLNode(a[i]);
                node.setNext(next);
                next.setPrev(node);
                node=next;
            }
        }

    }

    public DLLNode getRoot() {
        return root;
    }

    public void setRoot(DLLNode root) {
        this.root = root;
    }

    public void print(){
        DLLNode node = this.root;
        while(node!=null && node.getNext()!=this.root){
            System.out.print(node.getData() + " ");
            node=node.getNext();
        }
        System.out.print(node.getData() + " ");
        System.out.println();
    }
}