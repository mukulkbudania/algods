package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class NumberOfDearrangements {
    int getDearrangements(int n){
        if(n==0) return 1;
        int x=1;int y=0;
        for(int i=2;i<=n;i++){
            int p=(i-1)*(x+y);
            x=y;
            y=p;
        }
        return y;
    }
    public static void main(String[] args){
        System.out.println(new NumberOfDearrangements().getDearrangements(4));
    }
}
