package prep.interview.geeks.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mukulbudania on 7/26/17.
 */
public class SubsetSum {

    public static void main(String[] args){
        int a[] = new int[]{1,1,2,5,6,7,10};
        int k = 8;
        subsetSum(a,k);
    }

    private static void subsetSum(int a[], int sum) {
        int b[] = new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=-1;
        }
        totalSum(a, b, 0, -1, sum);
    }

    private static void totalSum(int[] a, int[] b, int sumTillNow, int tupleIndex, int totalSum) {
        System.out.println("SumTillNow: " + sumTillNow + " tupleIndex: " + tupleIndex);
        if(sumTillNow==totalSum){
            //System.out.println("Result: ");
            print(b,a);
            //System.out.println("Sum: " + sumTillNow);

            b[tupleIndex]=-1;
            if(tupleIndex+1<a.length && totalSum-a[tupleIndex]+a[tupleIndex+1]<=totalSum){
                totalSum(a, b,sumTillNow-a[tupleIndex],tupleIndex-1,totalSum);
            }
            return;
        } else {
            if(tupleIndex<a.length && sumTillNow<=totalSum){
                for(int i=tupleIndex;i<a.length;i++){
                    if(sumTillNow+a[i]<=totalSum){
                        b[tupleIndex]=i;
                        totalSum(a,b,sumTillNow+a[i],tupleIndex+1,totalSum);
                    }
                }
            }
        }
    }

    private static void print(int a[],int b[]) {
        for(int i=0;i<a.length;i++){
            if(a[i]!=-1)
            System.out.print(a[i] + "(" + b[a[i]]+ ") ");
        }
        System.out.println();
    }
}
