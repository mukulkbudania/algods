package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class WeightTransformation {
    int getMaxweight(String x){
        int n = x.length();
        int dp[] = new int[n+1];
        dp[0]=0;dp[1]=1;

        for(int i=2;i<=n;i++){
            int max = Math.max(dp[i-1]+1,dp[i-2]+3);
            if(x.charAt(i-1)!=x.charAt(i-2))
                max= Math.max(max,dp[i-2]+4);
            dp[i]=max;
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(new WeightTransformation().getMaxweight("AAAAABB"));
    }
}
