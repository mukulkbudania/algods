package prep.interview.geeks.ds.linkedlist.singlelinkedlist;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class SegregateOddAndEvenNodes {
    public static void main(String[] args){
        LinkedList list = new LinkedList(new int[]{1,2,3,4,5});
        segregate(list);
        list.print();
    }

    private static void segregate(LinkedList list) {
        LLNode node = list.getRoot();
        if(node==null) return;
        LLNode lastOdd = node;
        LLNode lastEven = node.getNext();
        LLNode firstEven = lastEven;
        while (lastEven !=null && lastEven.getNext()!=null){
            lastOdd.setNext(lastEven.getNext());
            lastOdd=lastOdd.getNext();
            lastEven.setNext(lastOdd.getNext());
            lastEven = lastEven.getNext();
        }
        lastOdd.setNext(firstEven);
    }
}
