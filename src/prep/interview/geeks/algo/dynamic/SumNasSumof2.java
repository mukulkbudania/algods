package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/17/17.
 */
public class SumNasSumof2 {
    public static void main(String[] args){
        int t[] = new int[21];
        for(int i=0;i<21;i++)t[i]=0;
        t[0]=1;
        for(int i=1;i<20;i++){
            for(int j=0;j<i;j++){
                t[i]+=t[j];
            }
        }
        for(int i=0;i<21;i++){
            System.out.print(t[i] + " ");
        }
    }
}
