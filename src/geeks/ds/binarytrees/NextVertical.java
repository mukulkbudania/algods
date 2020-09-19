package geeks.ds.binarytrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mukulbudania on 7/13/17.
 */
public class NextVertical {

    private static class LevelBTreeNode{

        private BTreeNode node;

        private int level;

        public LevelBTreeNode(BTreeNode node,int level) {
            this.node = node;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public BTreeNode getNode() {
            return node;
        }
    }
    private static Map<Integer,List<LevelBTreeNode>> verticalMap = new HashMap<Integer, List<LevelBTreeNode>>();

    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4,2,5,1,6,3,7},new int[]{1,2,4,5,3,6,7});
        tree.printPreorder();
        tree.printInorder();
        tree.printPostorder();
        verticalMap.clear();
        buildVerticalMap(tree.getRoot(), 0, 0);
        printVerticalMap();
    }

    private static void printVerticalMap() {
        StringBuilder sb = new StringBuilder();
        for(int a: verticalMap.keySet()){
            sb.append("Key " + a + ": ");
            for(LevelBTreeNode node: verticalMap.get(a)){
                sb.append(node.getNode().getData() + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    private static void buildVerticalMap(BTreeNode root, int horizontal, int vertical) {
        if(root==null)return;
        if(verticalMap.containsKey(horizontal)){
            List<LevelBTreeNode> nodes = verticalMap.get(horizontal);
            LevelBTreeNode lastNode = nodes.get(nodes.size()-1);
            if (lastNode.getLevel() !=vertical)
                nodes.add(new LevelBTreeNode(root,vertical));
        } else {
            verticalMap.put(horizontal,new ArrayList<LevelBTreeNode>());
            verticalMap.get(horizontal).add(new LevelBTreeNode(root,vertical));
        }
        buildVerticalMap(root.getLeft(),horizontal-1,vertical+1);
        buildVerticalMap(root.getRight(),horizontal+1,vertical+1);
    }
}
