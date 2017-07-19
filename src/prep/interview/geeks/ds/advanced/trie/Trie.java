package prep.interview.geeks.ds.advanced.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 7/14/17.
 */
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode('\0');
    }
    public boolean insert(String word){
        if(!validate(word)) return false;
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
        return true;
    }

    private boolean validate(String word) {
        return word.toLowerCase().matches("^[a-z]+");
    }

    public boolean delete(String word){
        if(!validate(word)) return false;
        char[] arr = word.toCharArray();
        TrieNode node = this.root;
        for(int i=0;i<arr.length;i++){
            char index = arr[i];
            if(node.getChildren().get(index)==null){ return false;}
            if(node.getChildren().size()==1){
                node.getChildren().remove(index);
            }
            node=node.getChildren().get(index);
        }
        return true;
    }
    public List<String> prefixSearch(String word){
        List<String> result = new ArrayList<String>();
        if(!validate(word)) return result;
        char[] arr = word.toCharArray();
        TrieNode node = this.root;
        for(int i=0;i<arr.length;i++){
            char index = arr[i];
            if(node.getChildren().get(index)==null){ return result;}
            node=node.getChildren().get(index);
        }
        doDFS(node,word,result);
        return result;
    }

    private void doDFS(TrieNode node,String stringTillNow,List<String> result) {
        if(node.isEnd()) result.add(stringTillNow);
        for(Character ch: node.getChildren().keySet()){
            String newString = stringTillNow.concat(ch.toString());
            doDFS(node.getChildren().get(ch),newString,result);
        }
    }

    public boolean exactSearch(String word){
        if(!validate(word)) return false;
        char[] arr = word.toCharArray();
        TrieNode node = this.root;
        for(int i=0;i<arr.length;i++){
            char index = arr[i];
            if(node.getChildren().get(index)==null){ return false;}
            node=node.getChildren().get(index);
        }
        if(node.isEnd()) return true;
        return false;
    }
}
