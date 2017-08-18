package prep.interview.geeks.algo.binarysearch;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class Medianof2SortedArrays {
    public static void main(String[] args){
        int a[] = {1,2,3,6};
        int b[] = {4,6,7,8};
        System.out.println(median(a,b,0,0,4));
    }

    private static double median(int[] a, int[] b, int aStart, int bStart, int n) {
        if(n==0) return 0.0;
        if(n==1) return (a[aStart] + b[bStart])/2.0;
        if(n==2) return (Math.max(a[aStart],b[bStart]) + Math.min(a[aStart+1],b[bStart+1]))/2.0;
        int aMid = aStart + (n-1)/2;
        int bMid = bStart + (n-1)/2;
        if(a[aMid]>b[bMid])return median(a,b,aStart,bMid,n/2+1);
        else return median(a,b,aMid,bStart,n/2+1);
    }
}
