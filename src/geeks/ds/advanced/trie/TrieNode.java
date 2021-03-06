package geeks.ds.advanced.trie;

import java.util.HashMap;

/**
 * Created by mukulbudania on 7/14/17.
 */
public class TrieNode {
    private char val;
    private boolean isEnd = false;
    private int count=0;
    private HashMap<Character,TrieNode> children = new HashMap<Character, TrieNode>(26);

    public TrieNode(char a){
        setVal(a);
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
        this.children = children;
    }
}
