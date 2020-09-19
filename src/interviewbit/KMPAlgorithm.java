package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 8/8/17.
 */
public class KMPAlgorithm {

    public static void main(String[] args){
        String a = "bacbababababacbab";
        String b = "ababa";
        List<Integer> indexes = getIndexes(a, b);
    }

    private static List<Integer> getIndexes(String a, String b) {
        List<Integer> result = new ArrayList<>();
        int n = a.length();
        int m = b.length();
        int[] lps = createLPS(b);

        for(int i=0;i<lps.length;i++){
            System.out.print(lps[i] + " ");
        }
        int j=-1;
        for(int i=0;i<n;i++){
            while(j>=0 && a.charAt(i)!=b.charAt(j+1)){
                j=lps[j];
            }
            if(a.charAt(i)==b.charAt(j+1))j++;
            if(j==m-1){
                System.out.println("String found at: " + (i-j));
                result.add(i-j);
                j=lps[j];
            }
        }
        return result;
    }
    private static int[] createLPS(String a){
        if(a==null || a.isEmpty()) return new int[0];
        int n = a.length();
        int lps[] = new int[n];
        int prefixLength=-1;
        lps[0]=prefixLength;
        for(int i=1;i<n;i++){
            while(prefixLength>=0 && a.charAt(i)!=a.charAt(prefixLength+1)){
                prefixLength=lps[prefixLength];
            }
            if(a.charAt(i)==a.charAt(prefixLength+1))prefixLength++;
            lps[i]=prefixLength;
        }
        return lps;
    }
}
