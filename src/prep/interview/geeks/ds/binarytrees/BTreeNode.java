package prep.interview.geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/13/17.
 */
public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;
    private BTreeNode nextSibling;

    BTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BTreeNode getLeft() {
        return left;
    }

    public void setLeft(BTreeNode left) {
        this.left = left;
    }

    public BTreeNode getRight() {
        return right;
    }

    public void setRight(BTreeNode right) {
        this.right = right;
    }

    public BTreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(BTreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + this.getData());
        sb.append(" Left: ");
        if(this.getLeft()!=null) sb.append(this.getLeft().getData());
        else sb.append("NULL");
        sb.append(" Right: ");
        if(this.getRight()!=null) sb.append(this.getRight().getData());
        else sb.append("NULL");
        sb.append(" Sibling: ");
        if(this.getNextSibling()!= null) sb.append(this.getNextSibling().getData());
        else sb.append("NULL");
        return sb.toString();
    }
}
