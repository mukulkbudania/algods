package prep.interview.geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/15/17.
 */
public class DiameterOfTree {
    public static void main(String[] args){
        BinaryTree tree = BinaryTree.constructBinaryTree(new int[]{4,2,5,1,6,3,7},new int[]{1,2,4,5,3,6,7});
        System.out.println(getDiameter(tree));
    }

    private static int getDiameter(BinaryTree tree) {
        int[] h = {0};
        return getDiameter(tree.getRoot(), h);
    }

    private static int getDiameter(BTreeNode root, int[] height) {
        if(root==null) {
            height[0]=0;
            return 0;
        }
        int[] lh = {0};int[] rh = {0};
        int leftDiameter = getDiameter(root.getLeft(),lh);
        int rightDiameter = getDiameter(root.getRight(),rh);
        height[0]=1+max(lh[0],rh[0]);
        return max(max(leftDiameter,rightDiameter),lh[0]+rh[0]+1);
    }

    private static int max(int a, int b) {
        return (a>b)?a:b;
    }
}
