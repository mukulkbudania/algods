package prep.interview.geeks.companies.interviewbit.math;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class IsPower {
    public boolean isPower(int a) {
        if(a==0|| a==1) return true;
        int x = (int) java.lang.Math.sqrt(a);
        List<Integer> primes = getAllPrimes(x);
        int p=0;
        while(a>1){
            Iterator<Integer> it = primes.iterator();
            while(it.hasNext()){
                int number = it.next();
                int powerCount=0;
                while(a%number==0){
                    powerCount++;
                    a=a/number;
                }
                if(p==0)p=powerCount;
                else p=gcd(powerCount,p);
                if(p==1) return false;
            }
            if(a>1) return false;
        }
        if(p>1) return true;
        else return false;
    }

    private int gcd(int a, int b) {
        if(a==0 || b==0) return 0;
        if(a==b) return a;
        int min = java.lang.Math.min(a, b);
        int max = java.lang.Math.max(a, b);
        return gcd(min,max-min);
    }

    private List<Integer> getAllPrimes(int x) {
        boolean b[] = new boolean[x+1];
        for(int i=2;i<=x;i++)b[i]=true;
        int j=2;
        while(2*j<=x){
            for(int i=2*j;i<=x;i=i+j) b[i]=false;
            j++;
        }
        List<Integer> result = new LinkedList<>();
        for(int i=2;i<=x;i++){
            if(b[i])result.add(i);
        }
        return result;
    }
    public static void main(String[] args){
        int a = 2;
        IsPower isPower = new IsPower();
        System.out.println(isPower.isPower(a));
    }
}
