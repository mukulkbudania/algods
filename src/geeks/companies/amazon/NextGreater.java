package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class NextGreater {
    public static void main(String[] args){
        int a[] = {1, 3, 2, 4 };
        int p[] = new int[a.length];
        int max = a[0];int start=0;
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
                while (start<i)p[start++]=max;
            }
        }
        while (start<a.length)p[start++]=-1;
        print(p);
    }

    private static void print(int[] p) {
        for(int i=0;i<p.length;i++) System.out.print(p[i]+" ");
    }
}
