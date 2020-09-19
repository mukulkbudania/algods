package geeks.companies.amazon;

import geeks.ds.linkedlist.singlelinkedlist.LLNode;
import geeks.ds.linkedlist.singlelinkedlist.LinkedList;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class AllOddsTogether {
    public static void main(String[] args){
        LinkedList list = new LinkedList(new int[]{1,2,3,4,5,6,7,8,9});
        getAllOddsTogether(list);
        list.print();
    }

    private static void getAllOddsTogether(LinkedList list) {
        if(list==null || list.getRoot()==null || list.getRoot().getNext()==null) return;
        LLNode lastOdd = list.getRoot();
        LLNode lastEven = lastOdd.getNext();
        while(lastEven!=null){

            LLNode nextOdd = lastEven.getNext();
            if(nextOdd==null) return;

            LLNode nextEven = nextOdd.getNext();
            nextOdd.setNext(lastOdd.getNext());

            lastOdd.setNext(nextOdd);
            lastOdd = nextOdd;

            lastEven.setNext(nextEven);
            lastEven=nextEven;
        }


    }
}
