package prep.interview.geeks.algo.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 7/14/17.
 */
public class Permutation {
    private static List<String> strings = new ArrayList<String>();
    private static void permute(char[] arr, int start, int end){
        if(start==end){
            strings.add(new String(arr));
        }
        for(int i=start;i<end;i++){
            swap(arr,start,i);//set
            permute(arr,start+1,end); //check if solution exists
            swap(arr,i,start);
        }

    }

    private static void swap(char[] arr, int i, int j) {
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
        for(String s: strings){
            System.out.println(s);
        }
    }
}
