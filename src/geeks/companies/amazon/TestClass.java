package geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class TestClass {
    private static long INDEX= (long)(Math.pow(10,9))+7;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] values = scanner.nextLine().split(" ");
        long a[] = new long[n];
        for(int i=0;i<n;i++){
            a[i] = Long.parseLong(values[i]);
        }
        System.out.println(getAllCombinations(a,n));
    }

    private static long getAllCombinations(long[] a,int n) {
        long product = 1;
        for(int i=0;i<n;i++){
            long count=0;
            long val = a[i];
            if(val == 0){
                count=1;
            } else {
                while(val>0){
                    count=(count+val+1)%INDEX;
                    val=val>>1;
                }
            }
            product = (product * count)%INDEX;
        }
        return product;
    }
}
