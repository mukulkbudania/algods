package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args){
        String a = "GEEKSFORGEEKS";
        String b = "SKEEGROFSKEEG";
        System.out.println(getSubsequence(a,b));
    }

    private static int getSubsequence(String a, String b) {
        int[][] l = new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                if(i==0 || j==0) l[i][j]=0;
                else if(a.charAt(i-1)==b.charAt(j-1))l[i][j]=1+l[i-1][j-1];
                else l[i][j]=Math.max(l[i-1][j],l[i][j-1]);
            }
        }
        return l[a.length()][b.length()];
    }
}
