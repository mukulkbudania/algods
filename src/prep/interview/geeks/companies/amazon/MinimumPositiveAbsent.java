package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class MinimumPositiveAbsent {
    public static void main(String[] args){
        int a[] = {0, 10, 2, -10, -20};
        int len = segregate(a);
        System.out.println(findMin(a, len));
    }

    private static int findMin(int[] a, int len) {
        for(int i=0;i<=len;i++){
            int y = Math.abs(a[i])-1;
            if(y<=len && a[y]>0){
                a[y]=-a[y];
            }
        }
        for(int i=0;i<=len;i++){
            if(a[i]>0) return (i+1);
        }
        return len+1;
    }

    private static void print(int[] a) {
        for(int i=0;i<a.length;i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    private static int segregate(int[] a) {
        int i=a.length-1,j=a.length-1;
        while (i>=0){
            if(a[i]<=0){
                swap(a,i,j);j--;
            }
            i--;
        }
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
