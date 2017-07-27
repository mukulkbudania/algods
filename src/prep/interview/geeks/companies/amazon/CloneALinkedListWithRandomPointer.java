package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.linkedlist.singlelinkedlist.LinkedList;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class CloneALinkedListWithRandomPointer {
    private static class PointerNode{
        int data;
        PointerNode next;
        PointerNode random;
        PointerNode(int data){
            this.data=data;
        }
    }
    private static class PointerList {
        PointerNode start;
    }
    public static void main(String[] args){
        PointerList list = new PointerList();
        PointerNode node1 = new PointerNode(1);
        PointerNode node2 = new PointerNode(2);
        PointerNode node3 = new PointerNode(3);
        PointerNode node4 = new PointerNode(4);
        PointerNode node5 = new PointerNode(5);
        PointerNode node6 = new PointerNode(6);
        node1.next=node2;node2.next=node3;node3.next=node4;node4.next=node5;node5.next=node6;
        node1.random=node3;node2.random=node1;node3.random=node6;node4.random=node5;node5.random=node3;node6.random=node2;
        list.start=node1;

        PointerList newList = recreate(list);
        PointerNode node = newList.start;
        while(node != null){
            StringBuilder builder = new StringBuilder();
            builder.append("Data" + node.data);
            if(node.next!=null) builder.append(" Next: " + node.next.data);
            if(node.random!=null) builder.append(" Random: " + node.random.data);
            System.out.println(builder.toString());
            node = node.next;
        }
    }

    private static PointerList recreate(PointerList list) {
        if ( list==null || list.start==null) return null;

        PointerNode node = list.start;
        while(node != null){
            PointerNode newNode = new PointerNode(node.data);
            PointerNode next = node.next;
            node.next = newNode;
            newNode.next = next;
            node = next;
        }
        node = list.start;
        while(node!=null){
            node.next.random = node.random.next;
            node = node.next.next;
        }
        node = list.start;
        PointerNode resultStart = node.next;
        PointerNode node2 = resultStart;
        while (node2.next!=null){
            node.next=node2.next;
            node = node.next;
            node2.next=node.next;
            node2 = node2.next;
        }
        PointerList result = new PointerList();
        result.start = resultStart;
        return result;
    }

}
