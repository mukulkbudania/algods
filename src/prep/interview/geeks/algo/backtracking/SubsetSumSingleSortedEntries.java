package prep.interview.geeks.algo.backtracking;

/**
 * Created by mukulbudania on 7/26/17.
 */
public class SubsetSumSingleSortedEntries {

    public static void main(final String[] args){
        final int[] a = new int[]{1,2,5,6,7,10};
        final int k = 8;
        subsetSum(a,k);
    }

    private static void subsetSum(final int[] a, final int sum) {
        final int[] b = new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=0;
        }
        totalSum(a, b, 0, 0, 0, sum);
    }

    private static void totalSum(final int[] a, final int[] b,
                                 final int sumTillNow,
                                 final int tupleSize, final int tupleIndex, final int totalSum) {
        print(b,tupleSize);
        System.out.println(" SumTillNow: " + sumTillNow + " TupleSize: " + tupleSize + " TupleIndex: " + tupleSize + " TotalSum: " + totalSum);
        if(sumTillNow==totalSum){
            print(b,tupleSize);
        } else {
            if(tupleIndex<a.length && sumTillNow+a[tupleIndex]<=totalSum){
                for(int i=tupleIndex;i<a.length;i++){
                    if(sumTillNow+a[i]<=totalSum){
                        b[tupleSize]=a[i];
                        totalSum(a,b,sumTillNow+a[i],tupleSize+1,i+1,totalSum);
                    }
                }
            }
        }
    }

    private static void print(final int[] a,
                              final int size) {
        for(int i=0;i<size;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
