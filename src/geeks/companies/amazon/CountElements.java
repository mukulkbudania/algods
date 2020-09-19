package geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/28/17.
 * http://practice.geeksforgeeks.org/problems/count-the-elements/0
 */
public class CountElements {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            int a[] = parseStringToInt(in.nextLine().split(" "));
            int b[] = parseStringToInt(in.nextLine().split(" "));
            int max = getMax(a);
            int[] finalArray = new int[max+1];
            for(int j=1;j<=max;j++){
                finalArray[j]=0;
            }
            for(int j=0;j<b.length;j++){
                if(b[j]<=max){
                    finalArray[b[j]]++;
                }
            }
            for(int j=1;j<=max;j++){
                finalArray[j]+=finalArray[j-1];
            }
            for(int j=0;j<a.length;j++){
                System.out.print(finalArray[a[j]] + " ");
            }
        }
    }

    private static int getMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]>max)max=a[i];
        }
        return max;
    }

    private static int[] parseStringToInt(String[] split) {
        int[] ints = new int[split.length];
        for(int i=0;i<split.length;i++){
            ints[i]=Integer.parseInt(split[i]);
        }
        return ints;
    }
}
