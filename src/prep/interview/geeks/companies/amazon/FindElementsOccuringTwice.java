package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.advanced.trie.TrieNode;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/twice-counter/0
 */
public class FindElementsOccuringTwice {
    private static class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode('\0');
        }
        public int insert(String word){
            char[] arr = word.toCharArray();
            TrieNode node = this.root;
            for(int i=0;i<arr.length;i++){
                char index = arr[i];
                if(node.getChildren().get(index)==null){
                    node.getChildren().put(index,new TrieNode(arr[i]));
                }
                node = node.getChildren().get(index);
            }
            node.setEnd(true);
            node.setCount(node.getCount()+1);
            return node.getCount();
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(in.nextLine());
            int count = 0;
            String[] words = in.nextLine().split(" ");
            Trie trie = new Trie();
            for(String word: words){
                int c = trie.insert(word);
                if(c==2)count++;
                else if(c==3)count--;
            }
            System.out.println(count);
        }
    }
}
