package geeks.ds.bst;

import geeks.ds.binarytrees.BTreeNode;
import geeks.ds.binarytrees.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class PrintAllBSTs {
    public static void main(String[] args){
        int n = 3;
        List<BTreeNode> nodes = constructBSTs(1,n);
        for(BTreeNode node: nodes){
            BinaryTree tree = new BinaryTree();
            tree.setRoot(node);
            tree.printPreorder();
        }
    }

    private static List<BTreeNode> constructBSTs(int start,int end) {
        List<BTreeNode> bsts = new ArrayList<>();
        if(start>end){
            bsts.add(new BTreeNode(-1));
        }
        for(int i=start;i<=end;i++){
            List<BTreeNode> leftSubtrees = constructBSTs(start,i-1);
            List<BTreeNode> rightSubtrees = constructBSTs(i+1,end);
            for(int j=0;j<leftSubtrees.size();j++){
                BTreeNode left = leftSubtrees.get(j);
                for(int k=0;k<rightSubtrees.size();k++){
                    BTreeNode right = rightSubtrees.get(k);
                    BTreeNode node = new BTreeNode(i);
                    if(left.getData()!=-1)node.setLeft(left);
                    if(right.getData() !=-1)node.setRight(right);
                    bsts.add(node);
                }
            }
        }
        return bsts;
    }
}
