package prep.interview.geeks.companies.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class StockBuySell {
    public static void main(String[] args){
        int a[] = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};
        print(getPairs(a));
    }

    private static void print(List<Pair> pairs) {
        for(int i=0;i<pairs.size();i++){
            System.out.print("(" + pairs.get(i).start + " " + pairs.get(i).end + ") ");
        }
    }

    private static List<Pair> getPairs(int a[]) {
        List<Pair> pairs = new ArrayList<>();
        if(a.length<2) return pairs;
        int i=1;
        int start=0;int end=0;
        while(i<a.length){
            while (i<a.length && a[i]<a[i-1] )i++;
            start=a[i-1];
            while (i<a.length && a[i]>a[i-1])i++;
            end=a[i-1];
            if(start!=a.length-1)
            pairs.add(new Pair(start,end));
        }
        return pairs;
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start=start;
            this.end=end;
        }
    }
}
