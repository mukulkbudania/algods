package interviewbit.trees;

import java.util.*;

/**
 * Created by mukulbudania on 8/29/17.
 */
public class PeopleTaller {
    static class TreeNode {
        TreeNode left,right;
        Pair val;

        public TreeNode(int data){
            this.val = new Pair(data,0);
        }

        public void inorder(ArrayList<Integer> output){
            if(this.left != null){
                this.left.inorder(output);
            }
            output.add(this.val.data);
            if(this.right != null){
                this.right.inorder(output);
            }
        }

        public void insert(Pair p){
            if(p.index <= this.val.index){
                this.val.index++;
                if(this.left != null){
                    this.left.insert(p);
                }else{
                    TreeNode newNode = new TreeNode(p.data);
                    this.left = newNode;
                }
            }else{
                if(this.right != null){
                    this.right.insert(new Pair(p.data,p.index - this.val.index));
                }else{
                    TreeNode newNode = new TreeNode(p.data);
                    this.right = newNode;
                }
            }
        }
    }


    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        int n = heights.size();
        List<Pair> pairs = new ArrayList<>(n);
        for(int i=0;i<n;i++) pairs.add(new Pair(heights.get(i),infronts.get(i)));
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.data-o1.data;
            }
        });
        TreeNode root = new TreeNode(pairs.get(0).data);

        for(int i=1;i<heights.size();i++){
            root.insert(pairs.get(i));
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        root.inorder(output);
        return output;
    }

    public static void main(String[] args){
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,3,4,5,6}));
        ArrayList<Integer> frontList = new ArrayList<Integer>(Arrays.asList(new Integer[]{3,2,1,2,0,0}));
        ArrayList<Integer> integers = new PeopleTaller().order(numList, frontList);
        for(int i: integers) System.out.print(i + " ");
    }

    private static class Pair {
        int data;
        int index;
        public Pair(Integer data, Integer index) {
            this.data = data;
            this.index = index;
        }

    }
}
