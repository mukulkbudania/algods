package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LLNode;
import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LinkedList;

/**
 * Created by mukulbudania on 7/20/17.
 */
public class AddNumbersinLinkedList {
    public static void main(String[] args){
        LinkedList l1 = new LinkedList(new int[]{1,3,4,5,6});
        LinkedList l2 = new LinkedList(new int[]{5,6,3,5,6,9});
        LinkedList l3 = addNumbers(l1, l2);
        l3.print();
    }

    private static LinkedList addNumbers(LinkedList l1, LinkedList l2) {
        LinkedList revL1 = reverse(l1);
        LinkedList revL2 = reverse(l2);
        LinkedList revL3 = addLists(revL1,revL2);
        return reverse(revL3);
    }

    private static LinkedList addLists(LinkedList l1, LinkedList l2) {
        if(l1==null || l1.getRoot()==null)return l2;
        if(l2==null || l2.getRoot()==null) return l1;
        LinkedList result = new LinkedList();
        LLNode startNode = new LLNode(0);
        result.setRoot(startNode);
        LLNode n1 = l1.getRoot(); LLNode n2 = l2.getRoot(); LLNode n3 = startNode;
        int carry=0;
        while(n1!=null && n2!=null){
            int val = n1.getData() + n2.getData() + carry;
            if(val>=10) {val -= 10; carry = 1;}
            else carry = 0;
            LLNode newNode = new LLNode(val);
            n3.setNext(newNode); n3 = newNode; n1=n1.getNext(); n2=n2.getNext();
        }
        if(n1==null){
            while(n2!=null){
                int val = n2.getData() + carry;
                if(val>=10) { val -= 10; carry = 1; }
                else carry = 0;
                LLNode newNode = new LLNode(val);
                n3.setNext(newNode); n3 = newNode; n2=n2.getNext();
            }
        }
        if(n2==null){
            while(n1!=null){
                int val = n1.getData() + carry;
                if(val>=10) { val -= 10; carry = 1; }
                else carry = 0;
                LLNode newNode = new LLNode(val);
                n3.setNext(newNode); n3 = newNode; n1=n1.getNext();
            }
        }
        if(carry==1) n3.setNext(new LLNode(1));

        result.setRoot(startNode.getNext());
        return result;
    }

    private static LinkedList reverse(LinkedList list) {
        if(list==null || list.getRoot()==null) return list;
        else list.setRoot(recursiveReverse(list.getRoot()));
        return list;
    }

    private static LLNode recursiveReverse(LLNode node) {
        LLNode next = node.getNext();
        node.setNext(null);
        if(next==null) return node;
        else {
            LLNode p = recursiveReverse(next);
            next.setNext(node);
            return p;
        }
    }
}
