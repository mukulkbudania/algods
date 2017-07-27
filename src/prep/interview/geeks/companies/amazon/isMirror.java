package prep.interview.geeks.companies.amazon;

import prep.interview.geeks.ds.binarytrees.BTreeNode;
import prep.interview.geeks.ds.binarytrees.BinaryTree;

/**
 * Created by mukulbudania on 7/21/17.
 */
public class isMirror {
    public static void main(String[] args){

    }
    private static boolean isMirror(BTreeNode left, BTreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return ((left.getData()==right.getData()) &&  (isMirror(left.getLeft(),right.getRight())) && (isMirror(right.getLeft(),left.getRight())));
    }
}
