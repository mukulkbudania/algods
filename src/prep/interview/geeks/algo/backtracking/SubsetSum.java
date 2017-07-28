package prep.interview.geeks.algo.backtracking;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class SubsetSum {

    public static void main(String[] args){
        Integer a[] = {1, 6, 5, 11};
        System.out.println(minSubsetSum(a));
    }

    private static double minSubsetSum(Integer[] a) {
        Collections.sort(Arrays.asList(a));
        int sum=0;
        for(int num:a){
            sum+=num;
        }
        return minSubsetSum(a,0,0,sum/2.0)*2;
    }

    private static double minSubsetSum(Integer[] a, int index,int sumtillNow, double sum) {
        if(index>=a.length){
            if(sumtillNow>sum){
                return sumtillNow-sum;
            } else {
                return sum-sumtillNow;
            }
        }
        if(sumtillNow>sum){
            return sumtillNow-sum;
        }
        double min = sum-sumtillNow;
        for(int i=index;i<a.length;i++){
            if(sumtillNow+a[i]<sum){
                min = Math.min(min,minSubsetSum(a,i+1,sumtillNow+a[i],sum));
            }
        }
        return min;
    }
}
