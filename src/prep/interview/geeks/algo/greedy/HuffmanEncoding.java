package prep.interview.geeks.algo.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class HuffmanEncoding {
    public static void main(String[] args){
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        Queue<Node> priorityQueue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for(int i=0;i<arr.length;i++){
            priorityQueue.add(new Node(arr[i],freq[i]));
        }
        while(priorityQueue.size()>1){
            Node a = priorityQueue.poll();
            Node b = priorityQueue.poll();
            Node c = new Node('\0',a.getValue()+b.getValue());
            c.setLeft(a);
            c.setRight(b);
            priorityQueue.add(c);
        }
        Node root = priorityQueue.poll();
        inorder(root,"");
    }

    private static void inorder(Node root,String path) {
        if(root==null)return;
        inorder(root.getLeft(),path+"0");
        if(root.getData()!='\0'){
            System.out.println("Data: " + root.getData() + " Code: " + path);
        }
        inorder(root.getRight(),path+"1");
    }


    private static class Node {
        private char data;
        private int value;
        private Node left;
        private Node right;

        public Node(char data, int value) {
            this.data = data;
            this.value = value;
        }

        public char getData() {
            return data;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
