package prep.interview.geeks.algo.bits;

/**
 * Created by mukulbudania on 7/28/17.
 * http://practice.geeksforgeeks.org/problems/check-set-bits/0
 */
public class CheckSetBits {
    public static void main(String[] args) {
        int a = 15;
        System.out.println(checkSetBits(a));
    }

    private static boolean checkSetBits(int a) {
        if(a==0) return false;
        while (a>0){
            int b = a&1;
            if(b!=1) return false;
            a=a>>1;
        }
        return true;
    }
}
