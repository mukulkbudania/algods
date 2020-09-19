package interviewbit.dynamic;

import java.util.*;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class SubMatricesWithSumZero {
    private int getSumZero(List<Integer> A){
        int result = 0;int sum=0;
        Map<Integer,Integer> freq = new HashMap<>();
        for(int a: A){
            sum+=a;
            if(freq.containsKey(sum))
                freq.put(sum,freq.get(sum)+1);
            else freq.put(sum, 1);
        }
        for(int a:freq.keySet()){
            if(a==0) freq.put(0,freq.get(0)+1);
            result += nC2(freq.get(a));
        }
        return result;
    }

    private int nC2(Integer n) {
        return (n)*(n-1)/2;
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int result=0;
        int n = A.size();
        int m = A.get(0).size();
        for(int start=0;start<n;start++){
            List<Integer> list = new ArrayList<Integer>(m);
            for(int i=0;i<m;i++)list.add(0);
            for(int end=start;end<n;end++){
                for(int i=0;i<m;i++){
                    list.set(i,list.get(i)+A.get(end).get(i));
                }
                result+=getSumZero(list);
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[][] a = {
                {-1,1},{1,-1}
        };
        System.out.println(new SubMatricesWithSumZero().solve(getListOfList(a,2,2)));
    }

    private static ArrayList<ArrayList<Integer>> getListOfList(int[][] a,int n,int m) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<m;j++){
                list.add(a[i][j]);
            }
            result.add(list);
        }
        return result;
    }
}
