package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class NumberOfTraingles {
    public static void main(String[] args){
        int a[] = {4,6,7,8,9};
        System.out.println(countTriangles(a));
    }

    private static int countTriangles(int[] a) {
        int n = a.length;
        int count=0;
        for(int i=0;i<n-2;i++){
            //Move either k or j. j would always be less than k. So O(n)
            int k=i+2;
            for(int j=i+1;j<n-1;j++){
                while (k<n&& a[i]+a[j]>a[k])++k;
                count+=k-j-1;
            }
        }
        return count;
    }
}
