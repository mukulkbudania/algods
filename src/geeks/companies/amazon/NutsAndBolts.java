package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class NutsAndBolts {
    public static void main(String[] args){
        int a[] = {8, 5, 4, 7, 2, 6, 3 ,9, 1};
        int b[] = {9, 2, 7, 4, 5, 6, 3, 8, 1};
        assign(a,b,0, 8);
        print(a);
        print(b);
    }

    private static void assign(int[] a, int[] b,int start,int end) {
        if(start>=end)return;
        int x = a[start];
        int i=start;int j=end;
        int index = -1;

        while (i<=j){
            while(b[i]<=x && i<=j){
                if(b[i]==x)index=i;
                i++;
            }
            while (b[j]>=x && i<=j){
                if(b[j]==x) index=j;
                j--;
            }
            if(i<j) swap(b,i++,j--);
        }
        swap(b,j,index);

        i=start+1; j=end;
        while (i<=j){
            while(a[i]<=x && i<=j) i++;
            while (a[j]>=x && i<=j) j--;
            if(i<j) swap(a,i++,j--);
        }
        swap(a,j,start);

        assign(a,b,start,j-1);
        assign(a,b,j+1,end);
    }

    private static void swap(int[] b, int i, int j) {
        int temp = b[i];
        b[i] = b[j];
        b[j] = temp;
    }

    private static void print(int[] a) {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
