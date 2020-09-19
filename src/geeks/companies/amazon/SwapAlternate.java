package geeks.companies.amazon;

import geeks.ds.linkedlist.singlelinkedlist.LLNode;
import geeks.ds.linkedlist.singlelinkedlist.LinkedList;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/20/17.
 */
public class SwapAlternate {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int x=0;x<t;x++){
            int num = Integer.parseInt(in.nextLine());
            int a[] = new int[num];
            for(int i=0;i<num;i++){
                a[i]=in.nextInt();
            }
            in.nextLine();
            LinkedList list = new LinkedList(a);
            swapAlternate(list);
            list.print();
        }
    }

    private static void swapAlternate(LinkedList linkedList) {
        LLNode node = linkedList.getRoot();
        while(node!=null){
            LLNode node2 = node.getNext();
            if(node2!=null){
                int temp = node.getData();
                node.setData(node2.getData());
                node2.setData(temp);
                node=node2.getNext();
            } else {
                break;
            }
        }
    }
}
