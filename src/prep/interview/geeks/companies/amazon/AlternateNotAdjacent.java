package prep.interview.geeks.companies.amazon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by mukulbudania on 7/30/17.
 */
public class AlternateNotAdjacent {
    public static void main(String[] args){
        String a = "bbbabacd";
        System.out.println(getAlternating(a.toCharArray()));
    }

    private static boolean getAlternating(char[] a) {
        int freq[] = new int[26];
        for(int i=0;i<26;i++) freq[i] = 0;
        for(int i=0;i<a.length;i++) freq[a[i]-'a']++;
        Queue<Node> nodes = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.freq-o1.freq;
            }
        });
        for(int i=0;i<26;i++){
            if(freq[i]>0)
            nodes.add(new Node((char)('a'+i),freq[i]));
        }
        StringBuilder sb = new StringBuilder();
        Node x = nodes.poll();
        sb.append(x.data);
        x.freq--;
        while (!nodes.isEmpty()){
            Node y = nodes.poll();
            sb.append(y.data);
            y.freq--;
            if(x.freq>0){
                nodes.add(x);
            }
            x=y;
        }
        if(x.freq>0) return false;
        else return true;
    }

    private static class Node {
        char data;
        int freq;

        public Node(char c, int i) {
            this.data=c;
            this.freq=i;
        }
    }
}
