package prep.interview.geeks.algo.dynamic.lis;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int a[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubsequence(a));
    }

    private static int longestIncreasingSubsequence(int[] a) {
        int result=1;
        int[] lis = new int[a.length];
        lis[0]=1;
        for(int i=1;i<a.length;i++){
            //Find max lis[j] where a[j]<a[i]
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(a[j]<=a[i])lis[i]=Math.max(lis[i],1+lis[j]);
            }
            result = Math.max(lis[i],result);
        }
        return result;
    }
}
