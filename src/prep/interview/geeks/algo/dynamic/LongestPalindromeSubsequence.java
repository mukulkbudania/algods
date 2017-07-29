package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class LongestPalindromeSubsequence {
    public static void main(String[] args){
        String a = "GEEKSFORGEEKS";
        System.out.println(getLongestPalindrome(a.toCharArray()));
    }

    private static int getLongestPalindrome(char[] arr) {
        int dp[][] = new int[arr.length][arr.length];
        for(int i=0;i< arr.length;i++)dp[i][i]=1;
        for(int size=2;size<= arr.length;size++){
            for(int start=0;start<=arr.length-size;start++){
                int end=start+size-1;
                if(arr[start]==arr[end]){
                    if(size==2) dp[start][end]=2;
                    else dp[start][end]=2+dp[start+1][end-1];
                } else {
                    dp[start][end]=Math.max(dp[start+1][end],dp[start][end-1]);
                }
            }
        }
        return dp[0][arr.length-1];
    }
}
