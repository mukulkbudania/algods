package prep.interview.geeks.companies.amazon.hard;

/**
 * Created by mukulbudania on 7/30/17.
 */
public class WaysToDecode {
    public static void main(String[] args){
        String a = "123";
        System.out.println(waysToDecode(a.toCharArray()));
    }

    private static int waysToDecode(char[] chars) {
        int n=chars.length;
        if(n==0)return 0;
        if(n==1) return 1;
        int dp[] = new int[n+1];
        dp[n]=1;dp[n-1]=1;
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1];
            if((chars[i]-'0')*10 + (chars[i+1]-'0') <=26)
                dp[i]+=dp[i+2];
        }
        return dp[0];
    }
}
