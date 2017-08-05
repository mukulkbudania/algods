package prep.interview.geeks.companies.interviewbit.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by mukulbudania on 8/4/17.
 */
public class MaxRectangleWithPermutation {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int m=A.size();
        int n=A.get(0).size();
        int res=0;
        for(int i = 0; i < n; i++){
            if(A.get(0).get(i)==1) res++;
        }
        for(int i = 1; i < m; i++){
            int count[]=new int[m+1];
            for(int j = 0; j < n; j++){
                int val = 0;
                if(A.get(i).get(j) == 1) val = (A.get(i-1).get(j)+1);
                A.get(i).set(j,val);
                count[val]++;
            }
            int cnt=0;
            for(int k=m;k>=0;k--){
                cnt += count[k];
                res = Math.max(res, cnt * k);
            }
        }
        return res;
    }
    public static void main(String[] args){
        MaxRectangleWithPermutation m = new MaxRectangleWithPermutation();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);x.add(0);x.add(1);
        a.add(x);
        ArrayList<Integer> x1 = new ArrayList<>();
        x1.add(1);x1.add(1);x1.add(0);
        a.add(x1);
        ArrayList<Integer> x3 = new ArrayList<>();
        x3.add(0);x3.add(1);x3.add(1);
        a.add(x3);
        System.out.println(m.solve(a));
        print(a);
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for(List<Integer> list: a){
            for(int x: list){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
