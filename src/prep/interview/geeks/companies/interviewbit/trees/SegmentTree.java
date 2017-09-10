package prep.interview.geeks.companies.interviewbit.trees;

/**
 * Created by mukulbudania on 8/29/17.
 */
public class SegmentTree {
    private int[] segmentTree;

    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6,7};
        SegmentTree tree = new SegmentTree();
        tree.makeSegmentTree(a);
        for(int i=0;i<tree.segmentTree.length;i++){
            System.out.print(tree.segmentTree[i] + " ");
        }
        System.out.println();
        int start=2;int end=3;
        System.out.println(tree.getMin(a, start, end));
    }

    public int getMin(int[] a,int start,int end){
        if(start<0 || end>=a.length || start>end) return -1;
        return getMin(0,a.length-1,0,start,end);
    }

    private int getMin(int sTStart, int sTEnd,  int sTIndex, int start, int end) {
        if(sTStart>=start && sTEnd <=end)return segmentTree[sTIndex];
        if(start>sTEnd || end <sTStart)return Integer.MAX_VALUE;
        int mid = (sTStart + sTEnd)/2;
        return Math.min(getMin(sTStart,mid,sTIndex*2+1,start,end),getMin(mid+1,sTEnd,sTIndex*2+2,start,end));
    }

    private void makeSegmentTree(int[] a) {
        int size = getSegmentTreeSize(a.length);
        this.segmentTree = new int[size];
        makeSegmentTree(a,0,a.length-1,0);
    }

    private int makeSegmentTree(int[] a, int start, int end, int index) {
        if(start==end){
            segmentTree[index]=a[start];
            return segmentTree[index];
        }
        int mid = (start+end)/2;
        segmentTree[index] = Math.min(
                makeSegmentTree(a,start,mid,index*2+1),
                makeSegmentTree(a,mid+1,end,index*2+2));
        return segmentTree[index];
    }

    private static int getSegmentTreeSize(int length) {
        if(length==0) return 0;
        boolean power2 = true;
        int digits=0;
        while (length>0){
            int x = length&1;
            length=length>>1;
            digits++;
            if(power2 && x==1 && length>0)power2=false;
        }
        if(!power2)digits++;
        return (1<<(digits)) - 1;
    }
}
