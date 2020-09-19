package prep.interview.geeks.algo.dynamic;

public class AlternatingGameTopBottom {
    static int[][] dp;
    public static void main(final String[] args){
        final int[] a = {8,15,3,7};
        System.out.println(getMaxAmount(a));

    }

    private static int getMaxAmount(final int[] a) {
        dp = new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                dp[i][j]=0;
            }
        }
        return getMax(a,0,a.length-1);
    }

    private static int getMax(final int[] a,
                              final int start,
                              final int end) {
        System.out.println("Max + " + start + "  " +end);
        //print(dp);
        if(start>end) return 0;
        if(dp[start][end]!=0) return dp[start][end];
        dp[start][end] = Math.max(a[start]+Math.min(getMax(a,start+1,end-1),getMax(a,start+2,end)),
                                  a[end]+Math.min(getMax(a,start+1,end-1),getMax(a,start,end-2)));
        return dp[start][end];
    }

    private static void print(final int[][] dp, final int n) {
        System.out.println("DP: ");
        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                System.out.print(dp[i][k] + "  " );
            }
            System.out.println();
        }
    }

    private static int getMin(final int[] a,
                              final int start,
                              final int end) {
        System.out.println("Min + " + start + "  " +end);
        if(start>end) return 0;
        if(dp[start][end]!=0) return dp[start][end];
        dp[start][end]= Math.min(a[start]+getMax(a,start+1,end),a[end]+getMax(a,start,end-1));
        return dp[start][end];
    }

}
