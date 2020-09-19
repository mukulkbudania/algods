package geeks.companies.amazon;

import geeks.ds.linkedlist.singlelinkedlist.LLNode;
import geeks.ds.linkedlist.singlelinkedlist.LinkedList;

import java.util.Stack;

/**
 * Created by mukulbudania on 7/21/17.
 *
 */
public class DeleteNodesGreaterOnRight {
    public static void main(String[] args){
        LinkedList list = new LinkedList(new int[]{12, 15, 10, 11, 5, 6, 2, 3});
        delete(list);
        list.print();
    }

    private static void delete(LinkedList list) {
        if(list==null || list.getRoot()==null) return;
        Stack<LLNode> stack = new Stack<LLNode>();
        LLNode node = list.getRoot();
        while(node!=null){
            while(!stack.isEmpty() && node.getData()>stack.peek().getData()){
                stack.pop();
            }
            stack.push(node);
            node = node.getNext();
        }
        LLNode node1 = null;
        while (!stack.isEmpty()){
            node1 = stack.pop();
            if(!stack.isEmpty()){
                stack.peek().setNext(node1);
            }
        }
        list.setRoot(node1);
    }
}
