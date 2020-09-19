package geeks.ds.tree.segment;

import geeks.ds.binarytrees.BTreeNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by mukulbudania on 7/27/17.
 * http://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence/0
 */
public class SecondMinimum {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6,7};
        System.out.println(getSecondMinimum(a));
    }

    private static int getSecondMinimum(int[] a) {
        if(a.length<2) return -1;
        LinkedList<BTreeNode> nodes = new LinkedList<>();
        for(int i=0;i<a.length;i++){
            BTreeNode node = new BTreeNode(a[i]);
            nodes.add(node);
        }
        while (nodes.size()>1){
            LinkedList<BTreeNode> newNodes = new LinkedList<>();
            Iterator<BTreeNode> it = nodes.iterator();
            while (it.hasNext()){
                BTreeNode node1 = it.next();
                if(it.hasNext()){
                    BTreeNode node2 = it.next();
                    BTreeNode newNode = new BTreeNode(min(node1.getData(), node2.getData()));
                    newNode.setLeft(node1);
                    newNode.setRight(node2);
                    newNodes.add(newNode);
                } else {
                    newNodes.add(node1);
                }
            }
            nodes = newNodes;
        }
        BTreeNode smallest = nodes.get(0);
        int secondMax = Integer.MAX_VALUE;
        while(smallest.getLeft()!=null){
            BTreeNode left = smallest.getLeft();
            BTreeNode right = smallest.getRight();
            if(left.getData()==smallest.getData()){
                secondMax=min(secondMax, right.getData());
                smallest=left;
            } else {
                secondMax=min(secondMax,left.getData());
                smallest=right;
            }
        }
        return secondMax;
    }

    private static int min(int a, int b) {
        return a>b?b:a;
    }
}
