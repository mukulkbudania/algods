package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class MaxDiffIndex {
    public static void main(String[] args){
        int a[] = {34,8,10,3,2,80,30,33,1};
        System.out.println(getMaxDiff(a));
    }

    private static int getMaxDiff(int[] a) {
        int[] l = new int[a.length];
        int[] r = new int[a.length];
        l[0]=a[0];
        for(int i=1;i<a.length;i++) l[i]=Math.min(a[i], l[i - 1]);
        for(int i=a.length-2;i>=0;i--) r[i]=Math.max(a[i], r[i + 1]);
        int i=0;int j=0;
        int maxDiff = 0;
        while (i<a.length && j<a.length){
            if(l[i]<r[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j++;
            } else {
                i++;
            }
        }
        return maxDiff;
    }
}
