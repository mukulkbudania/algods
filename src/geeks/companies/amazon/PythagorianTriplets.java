package geeks.companies.amazon;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class PythagorianTriplets {
    public static void main(String[] args){
        Integer a[] = {3, 1, 4, 6, 5};
        printTriplets(a);
    }

    private static void printTriplets(Integer[] a) {
        int n = a.length;
        Collections.sort(Arrays.asList(a));
        for(int i=0;i<n;i++){
            a[i]=a[i]*a[i];
        }
        for(int i=0;i<n-2;i++){
            int j=i+1;int k=j+1;
            while (j<n-1 && k<n){
                if(a[i]+a[j]>a[k]){
                    k++;
                } else if(a[i]+a[j]==a[k]){
                    System.out.println("Triplet found: " + (int)Math.sqrt(a[i]) + " " + (int)Math.sqrt(a[j]) + " " + (int)Math.sqrt(a[k]));
                    j++;k++;
                } else {
                    if(j==k-1)k++;
                    j++;
                }
            }
        }
    }
}
