package geeks.algo.backtracking;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class PrintAllSubsets {
    static int count = 0;
    public static void main(String[] args){
        int a[] = new int[]{1,2,5,6,7,10};
        printSubsets(a);
        System.out.println("Count" + count);
    }

    private static void printSubsets(int[] a) {
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++)
            b[i]=-1;
        printSubsets(a,b,0,0);
    }

    private static void printSubsets(int[] a, int b[], int bindex, int index) {
        if(index==a.length){
            print(b,bindex);
            count++;
        } else {
            printSubsets(a,b,bindex,index+1);
            b[bindex]=a[index];
            printSubsets(a,b,bindex+1,index+1);
        }
    }

    private static void print(int[] b,int index) {
        for(int i=0;i<index;i++) System.out.print(b[i] + " ");
        System.out.println();
    }
}
