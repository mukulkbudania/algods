package interviewbit.trees;

import java.util.*;

/**
 * Created by mukulbudania on 8/29/17.
 */
public class VerticalOrderTraversal {

    private static class Pair{
        TreeNode val;
        int level;
        Pair(TreeNode val,int level){
            this.val=val;
            this.level=level;
        }
    }
    public void addNode(TreeNode n, Map<Integer,LinkedList<Integer>> cache,int level){
        if(n==null) return;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(n, level));
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(!cache.containsKey(p.level)) cache.put(p.level,new LinkedList<Integer>());
            cache.get(p.level).add(p.val.val);
            if(p.val.left!=null) q.add(new Pair(p.val.left,p.level-1));
            if(p.val.right!=null) q.add(new Pair(p.val.right,level+1));
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        Map<Integer,LinkedList<Integer>> cache = new TreeMap<>();
        addNode(A,cache,0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Integer entry: cache.keySet()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(cache.get(entry));
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args){
        TreeNode node = TreeNode.newTree();
        ArrayList<ArrayList<Integer>> lists = new VerticalOrderTraversal().verticalOrderTraversal(node);
        for(ArrayList<Integer> list:lists){
            for(int i: list) System.out.print(i + " ");
            System.out.println();
        }
    }
}
