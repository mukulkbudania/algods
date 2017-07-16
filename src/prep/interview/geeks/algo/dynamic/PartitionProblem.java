package prep.interview.geeks.algo.dynamic;

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

        boolean[][] dp = new boolean[sum+1][n+1];
        //Set all true when sum is 0
        for(int i=0;i<=n;i++){
            dp[0][i]=true;
        }
        //Set all false when numbers taken is 0
        for(int i=1;i<=sum;i++){
            dp[i][0]=false;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i][j-1]; //a[j-1] not taken
                if(a[j-1]<=i){
                    dp[i][j] =dp[i][j] || dp[i-a[j-1]][j-1]; //a[j-1] taken
                }
            }
        }
        return dp[sum][n];
    }
}
