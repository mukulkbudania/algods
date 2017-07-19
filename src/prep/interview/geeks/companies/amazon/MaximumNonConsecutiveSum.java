package prep.interview.geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/stickler-theif/0
 */
public class MaximumNonConsecutiveSum {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(in.nextLine());
            int a[] = new int[n];
            for(int j=0;j<n;j++)a[j]=in.nextInt();
            in.nextLine();
            System.out.println(getMaxval(a));
        }
    }
    private static int max(int a,int b){
        return a>b?a:b;
    }
    private static int getMaxval(int[] a){
        int n = a.length;
        if(n==0) return 0;
        if(n==1) return a[0];
        if(n==2) return max(a[0],a[1]);
        int dp[] = new int[n];
        dp[0]=a[0];dp[1]=max(a[0],a[1]);
        for(int i=2;i<n;i++){
            dp[i]=max(a[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
