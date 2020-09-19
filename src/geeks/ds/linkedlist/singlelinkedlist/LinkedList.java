package geeks.ds.linkedlist.singlelinkedlist;

/**
 * Created by mukulbudania on 7/18/17.
 */
public class LinkedList {
    private LLNode root;

    public LinkedList(){
        setRoot(null);
    }
    public LinkedList(int a[]){
        if(a.length>0){
            this.root = new LLNode(a[0]);
            LLNode node = root;
            for(int i=1;i<a.length;i++){
                LLNode next=new LLNode(a[i]);
                node.setNext(next);
                node=next;
            }
        }

    }

    public LLNode getRoot() {
        return root;
    }

    public void setRoot(LLNode root) {
        this.root = root;
    }

    public void print(){
        LLNode node = this.root;
        while(node!=null){
            System.out.print(node.getData() + " ");
            node=node.getNext();
        }
        System.out.println();
    }

}
