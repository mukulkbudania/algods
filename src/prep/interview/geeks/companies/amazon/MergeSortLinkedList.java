package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LLNode;
import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LinkedList;
import sun.awt.image.ImageWatched;

/**
 * Created by mukulbudania on 7/22/17.
 */
public class MergeSortLinkedList {

    public static void main(String[] args){
        LinkedList list = new LinkedList(new int[]{1,4,7,3,2,5,4,9,8});
        mergeSortList(list);
        list.print();
    }

    private static void mergeSortList(LinkedList list) {
        if(list==null || list.getRoot()==null) return;
        mergeSort(list.getRoot());
    }

    private static LLNode mergeSort(LLNode root) {
        if(root==null || root.getNext()==null) return root;
        LLNode middle = getMiddle(root);
        LLNode next = middle.getNext();
        middle.setNext(null);
        LLNode left = mergeSort(root);
        LLNode right = mergeSort(next);
        return merge(left,right);
    }

    private static LLNode merge(LLNode left, LLNode right) {
        LLNode result = null;
        if(left==null) return right;
        if(right==null) return left;
        if(left.getData()<right.getData()){
            result=left;
            result.setNext(merge(left.getNext(), right));
        } else {
            result=right;
            result.setNext(merge(right.getNext(),left));
        }
        return result;
    }

    private static LLNode getMiddle(LLNode root) {
        if(root==null) return root;
        LLNode tortoise = root;
        LLNode rabbit = root.getNext();
        while(rabbit!=null){
            if(rabbit.getNext()==null)break;
            rabbit=rabbit.getNext().getNext();
            tortoise=tortoise.getNext();
        }
        return tortoise;
    }

}
