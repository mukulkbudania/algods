package geeks.companies.amazon;

import geeks.ds.linkedlist.singlelinkedlist.LLNode;
import geeks.ds.linkedlist.singlelinkedlist.LinkedList;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/19/17.
 */
public class DeleteNNodeAfterMNodes {
    private static void deleteNodes(LinkedList list,int m,int n){
        if(n==0) return;
        LLNode node = list.getRoot();
        while(node!=null && m>0){
            node=node.getNext();
            m--;
        }
        if(node!=null){
            LLNode node2=node;
            while(node2!=null && n>0){
                node2=node2.getNext();
            }
            while(node2!=null){
                node.setData(node2.getData());
                node=node.getNext();
                node2=node2.getNext();
            }
            node.setNext(null);
        }
    }
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
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            LinkedList list = new LinkedList(a);
            deleteNodes(list,n,m);
            list.print();
        }
    }
}
