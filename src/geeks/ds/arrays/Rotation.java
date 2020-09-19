package geeks.ds.arrays;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class Rotation {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6};
        int k = 2;
        rotate(a,k);
        print(a);
    }

    private static void rotate(int[] a, int k) {
        reverse(a,0,a.length-1);
        reverse(a,0,k-1);
        reverse(a,k,a.length-1);
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
