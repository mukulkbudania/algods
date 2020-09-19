package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class AllZerosToEnd {
    public static void main(String[] args){
        int a[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        moveZeros(a);
        print(a);
    }

    private static void print(int[] a) {
        for(int i:a){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void moveZeros(int[] a) {
        int i=0;int first0=-1;
        while (i<a.length && a[i]!=0)i++;
        if(i!=a.length)first0=i;
        while (i<a.length){
            if(a[i]!=0){
                swap(a,first0,i);
                first0++;
            }
            i++;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
