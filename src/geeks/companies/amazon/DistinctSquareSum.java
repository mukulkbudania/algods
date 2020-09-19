package geeks.companies.amazon;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mukulbudania on 7/18/17.
 * http://practice.geeksforgeeks.org/problems/game-with-string/0
 */
public class DistinctSquareSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int x=0;x<t;x++){
            String str = in.nextLine();
            TreeMap<Integer,Integer> freqSet = getStringMap(str);
            int k = Integer.parseInt(in.nextLine());
            while(k>0){
                if(freqSet.size()==0)break;
                int key = freqSet.firstKey();
                int value = freqSet.get(key);
                if(value<=k){
                    k-=value;
                    freqSet.remove(key);
                    if(freqSet.get(key-1)!=null)
                        freqSet.put(key-1,freqSet.get(key-1)+value);
                    else freqSet.put(key-1,value);
                } else {
                    freqSet.put(key,value-k);
                    k=0;
                }
            }
            int sum=0;
            for(Integer key:freqSet.keySet()){
                sum+=freqSet.get(key)*key*key;
            }
            System.out.println(sum);
        }
    }

    private static TreeMap<Integer, Integer> getStringMap(String str) {
        TreeMap<Integer,Integer> result = new TreeMap<Integer, Integer>((Integer o1, Integer o2) -> o2-o1);
        int[] arr = new int[26];
        for(int i=0;i<26;i++)arr[i]=0;
        for(char a: str.toCharArray()) arr[a-'a']++;
        for(int i=0;i<26;i++){
            if(arr[i]==0)continue;
            if(result.get(arr[i])==null)result.put(arr[i],1);
            else result.put(arr[i],result.get(arr[i])+1);
        }
        return result;
    }
}
