package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class Find2Distinct {
    public static void main(String[] args){
        int[] a={1, 2, 3, 2, 1, 4};
        get2Distinct(a);
    }

    private static void get2Distinct(int[] a) {
        int xor=a[0];
        for(int i=1;i<a.length;i++)xor=xor^a[i];
        int x = firstSetBit(xor);
        int r = 1<<x;
        int xor1=0;
        int xor2=0;
        for(int i=0;i<a.length;i++){
            if((a[i]&r)>0)xor1^=a[i];
            else xor2^=a[i];
        }
        System.out.println(xor1 + " " + xor2);
    }

    private static int firstSetBit(int xor) {
        int counter=0;
        while(xor>0){
            if((xor & 1) == 1)return counter;
            else {xor=xor>>1;counter++;}
        }
        return counter;
    }
}
