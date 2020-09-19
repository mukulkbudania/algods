package geeks.ds.arrays;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class WaveArray {
    public static void main(String[] args){
        int a[] = {5,7,3,2,8};
        makeWaveArray(a);
        print(a);
    }

    private static void makeWaveArray(int[] a) {
        int n = a.length;
        for(int i=1;i<n;i=i+2){
            int largest = i;
            if(a[i-1]>a[largest])largest = i-1;
            if(i+1 < a.length && a[i+1]>a[largest]) largest=i+1;
            if(largest!=i)swap(a,largest,i);
        }
    }

    private static void swap(int[] a, int j, int i) {
        int temp = a[j];
        a[j]=a[i];
        a[i]=temp;
    }

    private static void print(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}