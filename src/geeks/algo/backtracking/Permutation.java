package geeks.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 7/14/17.
 */
public class Permutation {
    private static void print(char[] arr, int start, int end){
        System.out.print("Arr:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.print(" Start: " + start + " End: " + end);
        System.out.println();
    }
    private static List<String> strings = new ArrayList<String>();
    private static void permute(char[] arr, int start, int end){
        print(arr,start,end);
        if(start==end){
            strings.add(new String(arr));
        }
        for(int i=start;i<end;i++){
            System.out.println("Going in loop: " + start + " " + end + " "+ i);
            swap(false, arr,start,i);//set
            permute(arr,start+1,end); //check if solution exists
            swap(true,arr,i,start);
        }

    }

    private static void swap(boolean revert, char[] arr, int i, int j) {
        System.out.println("Revert: " + revert + " Swapping " + i + " " +arr[i] + " "+ j + " " + arr[j]);
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static List<String> getPermutations(String word){
        strings.clear();
        permute(word.toCharArray(),0,word.length());
        return strings;
    }

    public static void main(String[] args){
        String str = "hello";
        permute(str.toCharArray(),0,str.length());
        //for(String s: strings){
          //  System.out.println(s);
        //}
    }
}
