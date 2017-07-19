package prep.interview.geeks.ds.binarytrees;

/**
 * Created by mukulbudania on 7/13/17.
 */
public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;
    private BTreeNode nextSibling;
    private BTreeNode successor;

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

    public BTreeNode getSuccessor() {
        return successor;
    }

    public void setSuccessor(BTreeNode successor) {
        this.successor = successor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + this.getData());
        if(this.getLeft()!=null){
            sb.append(" Left: ");
            sb.append(this.getLeft().getData());
        }
        if(this.getRight()!=null){
            sb.append(" Right: ");
            sb.append(this.getRight().getData());
        }
        if(this.getNextSibling()!= null){
            sb.append(" Sibling: ");
            sb.append(this.getNextSibling().getData());
        }
        if(this.getSuccessor()!= null){
            sb.append(" Successor: ");
            sb.append(this.getSuccessor().getData());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BTreeNode bTreeNode = (BTreeNode) o;

        if (data != bTreeNode.data) return false;

        return true;
    }
}
