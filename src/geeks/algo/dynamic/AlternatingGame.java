package geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/1/17.
 */
public class AlternatingGame {
    public static void main(final String[] args){
        final int[] a = {8,12,15,2, 23, 16, 7, 8};
        System.out.println(getMaxAmount(a));

    }

    private static int getMaxAmount(final int[] a) {

        final int n = a.length;
        final int[][] dp = new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i]=a[i];
            dp[i][i+1]=Math.max(a[i],a[i+1]);
        }
        dp[n-1][n-1]=a[n-1];
        for(int size=3;size<=n;size++){
            for(int start=0;start<n-size+1;start++){
                final int end=start+size-1;
                dp[start][end]=Math.max(a[start] + Math.min(dp[start+1][end-1],dp[start+2][end]),
                        a[end] + Math.min(dp[start+1][end-1],dp[start][end-2]));
            }
        }
        return dp[0][n-1];
    }


}
