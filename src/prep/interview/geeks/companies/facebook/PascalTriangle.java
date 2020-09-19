package prep.interview.geeks.companies.facebook;

import java.util.ArrayList;

public class PascalTriangle {
    public static void main(final String[] args){
        final ArrayList<ArrayList<Integer>> result = new PascalTriangle().generate(5);
        for(int i=0;i<result.size();i++){
            for(int j = 0; j< result.get(i).size();j++){
                System.out.print( result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Integer>> generate(final int a) {

        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(a==0) return result;
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        for(int i=1;i<a;i++){
            row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
}