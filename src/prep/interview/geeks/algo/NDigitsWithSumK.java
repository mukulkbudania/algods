package prep.interview.geeks.algo;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class NDigitsWithSumK {
    public static void main(String[] args){
        int n = 7;
        int k = 2;
        if(k>9*n) System.out.println(-1);
        else System.out.println(noOfWays(n,k,false));
    }

    private static int noOfWays(int n, int k,boolean zeroAllowed) {
        if(n==0){
            if(k==0) return 1;
            else return 0;
        }
        if(k<0) return 0;
        int result = 0;
        int i=(zeroAllowed)?0:1;
        for(;i<=9;i++){
            result+=noOfWays(n-1,k-i,true);
        }
        return result;
    }
}
