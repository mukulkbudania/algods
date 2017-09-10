package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class SpecialKeyboard {
    public int getMaxA(int n){
        int[] dp = new int[n];
        for(int i=0;i<6;i++)dp[i]=i+1;
        for(int i=7;i<=n;i++){
            int max = 0;
            for(int j=i-3;j>0;j--){
                max = Math.max(max,(n-j-1)*dp[j-1]);
            }
            dp[i-1]=max;
        }
        return dp[n-1];
    }
    public static void main(String[] args){
        System.out.println(new SpecialKeyboard().getMaxA(9));
    }
}
