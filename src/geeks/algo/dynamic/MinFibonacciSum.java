package geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/6/17.
 */
public class MinFibonacciSum {
    public int fibsum(int a) {
        int dp[] = new int[a+1];
        for(int i=1;i<=a;i++)dp[i]=-1;
        int x=1;int y=1;
        while(x<=a){
            dp[x]=1;
            int p=x+y;
            x=y;
            y=p;
        }
        for(int i=1;i<=a;i++) System.out.print(dp[i] + " ");
        System.out.println();
        int lastfibNumber=1;
        for(int i=1;i<=a;i++){
            if(dp[i]==1)lastfibNumber=i;
            else dp[i]=dp[lastfibNumber] + dp[i-lastfibNumber];
        }
        for(int i=1;i<=a;i++) System.out.print(dp[i] + " ");
        System.out.println();
        return dp[a];
    }
    public static void main(String[] args){
        System.out.println(new MinFibonacciSum().fibsum(15));
    }
}
