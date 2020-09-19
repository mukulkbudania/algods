package geeks.ds.arrays;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class NextPermutation {
    public static void main(String[] args){
        int a[] = {1, 2, 3, 6, 5, 4};
        nextPermutation(a);
        print(a);
    }

    private static void nextPermutation(int[] a) {
        if(a.length<2) return;
        int i=a.length-2;
        while (i>=0 && a[i]>=a[i+1])i--;
        if(i==0) {reverse(a,0,a.length-1);return;}
        swap(a,i,a.length-1);
        reverse(a,i+1,a.length-1);
    }

    private static void reverse(int[] a, int start, int end) {
        int i=start;int j=end;
        while (i<j){
            swap(a,i,j);
            i++;j--;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    private static void print(int[] a) {
        for(int i:a){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
