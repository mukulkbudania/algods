package prep;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mukulbudania on 8/31/17.
 */
public class MaxValueWithKAdjacentSwaps {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        int a[] = new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            a[i]=Integer.parseInt(numbers[i]);
        }
        int k = Integer.parseInt(scanner.nextLine());
        int maxArray[] = getMaxArray(a);
        getMaxResult(a,maxArray,0,k);
        print(a);
    }

    private static int[] getMaxArray(int[] a) {
        int maxArray[] = new int[a.length];
        int max=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max)max=a[i];
            maxArray[i]=a[i];
        }
        return maxArray;
    }

    private static void print(int[] a) {
        Arrays.stream(a).forEach((i)->System.out.print(i + " "));
        System.out.println();
    }

    private static void getMaxResult(int[] number, int[] maxArray, int start, int k) {
        int len = number.length;
        if(start>len-1 || k<=0) return;

        //find max
        //TODO can be optimized using a max array.
        int max=start;
        for(int i=start+1,counter=0;i<len && counter<k;i++,counter++){
            if(number[i]>number[max])max=i;
        }

        //bubble up max
        for(int i=max-1;i>=start;i--){
            int temp = number[i];
            number[i]=number[i+1];
            number[i+1]=temp;
        }
        //decrement swaps
        getMaxResult(number,maxArray,start+1,k-(max-start));
    }
}
