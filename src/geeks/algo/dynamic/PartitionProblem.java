package geeks.algo.dynamic;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/12/17.
 * Check if a set can be partitioned into 2 subsets so the sum of both is same.
 * E.g: 1 5 11 5
 */

public class PartitionProblem {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String strSet[] = in.nextLine().split(" ");
            int[] set = new int[strSet.length];
            for(int i=0;i<strSet.length;i++){
                set[i] = Integer.parseInt(strSet[i]);
            }
            System.out.println("Output: " + getPartitionable(set));
        }
    }

    private static boolean getPartitionable(int[] a) {
        int n = a.length;int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[i];
        }
        if(sum%2!=0) return false;
        sum/=2;

        boolean[][] dp = new boolean[n+1][sum+1];
        //Set all true when sum is 0
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        //Set all false when numbers taken is 0
        for(int i=1;i<=sum;i++){
            dp[0][i]=false;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                dp[i][j] = dp[i-1][j]; //a[i-1] not taken
                if(a[i-1]<=j){
                    dp[i][j] = dp[i][j] || dp[i-1][j-a[i-1]]; //a[i-1] taken
                }
            }
        }
        return dp[n][sum];
    }
}
