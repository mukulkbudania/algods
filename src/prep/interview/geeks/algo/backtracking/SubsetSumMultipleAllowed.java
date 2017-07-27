package prep.interview.geeks.algo.backtracking;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class SubsetSumMultipleAllowed {
    public static void main(String[] args){
        int a[] = new int[]{1,2,5,6,7,10};
        int k = 8;
        subsetSum(a,k);
    }

    private static void subsetSum(int a[], int sum) {
        int b[] = new int[sum];
        for(int i=0;i<sum;i++){
            b[i]=0;
        }
        totalSum(a, b, 0, 0, 0, sum);
    }

    private static void totalSum(int[] a, int[] b,int sumTillNow,int tupleSize, int tupleIndex, int totalSum) {
        if(sumTillNow==totalSum){
            print(b,tupleSize);
        } else {
            if(tupleIndex<a.length && sumTillNow+a[tupleIndex]<=totalSum){
                for(int i=tupleIndex;i<a.length;i++){
                    if(sumTillNow+a[i]<=totalSum){
                        b[tupleSize]=a[i];
                        totalSum(a,b,sumTillNow+a[i],tupleSize+1,i,totalSum);
                    }
                }
            }
        }
    }

    private static void print(int a[],int size) {
        for(int i=0;i<size;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
