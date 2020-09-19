package geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/30/17.
 */
public class MinimumPalindromePartition {
    public static void main(String[] args){
        String a = "ababbbabbababa";
        System.out.println(getMinPartitions(a.toCharArray()));
    }

    private static int getMinPartitions(char[] a) {
        int n=a.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int size=2;size<=n;size++){
            for(int start=0;start<=n-size;start++){
                int end = start+size-1;
                if(a[start]==a[end] && (size==2 || dp[start+1][end-1]==0)) dp[start][end]=0;
                else{
                    int min = Integer.MAX_VALUE;
                    for(int k=start;k<end;k++){
                        min = Math.min(min,dp[start][k]+dp[k+1][end]);
                    }
                    dp[start][end]=1+min;
                }
            }
        }
        return dp[0][n-1];
    }
}
