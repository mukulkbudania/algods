package prep.interview.geeks.companies.interviewbit.dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class LongestArithematicSubsequence {
    public int solve(final List<Integer> A) {
        int n = A.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][n-1]=2;
        }
        int max = 0;
        for(int i=n-2;i>=0;i--){
            int j=i-1;int k=i+1;
            while (j>=0 && k<n){
                if(A.get(j)+ A.get(k)<2*A.get(i))k++;
                else if(A.get(j)+ A.get(k)>2*A.get(i)){dp[j][i]=2;j--;}
                else {
                    dp[j][i]=dp[i][k]+1;
                    max = Math.max(max,dp[j][i]);
                    j--;k++;
                }
            }
            if(k==n){
                while (j>=0){
                    dp[j][i]=2;j--;
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        LongestArithematicSubsequence s = new LongestArithematicSubsequence();
        System.out.println(s.solve(Arrays.asList(new Integer[]{100, 10, 8, 300, 6, 1, 4, 2})));
    }
}
