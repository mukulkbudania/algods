package geeks.companies.amazon;

/**
 * Created by mukulbudania on 8/1/17.
 */
public class MaxProductPair {
    public static void main(String[] args){
        int[] a = {1, 4, 3, 6, 7, 0};
        getMaxPair(a);
    }

    private static void getMaxPair(int[] a) {
        int n = a.length;
        if(a.length<2) System.out.println("Number of Elements is less than 2");
        int max = 0;
        int secondMax = 0;
        int maxNeg = 0;
        int secondMaxNeg = 0;
        for(int i=0;i<n;i++){
            if(a[i]>max){
                secondMax=max;
                max=a[i];
            } else if(a[i]>secondMax){
                secondMax=a[i];
            }
            if(a[i]<0 && Math.abs(a[i])>Math.abs(maxNeg)){
                secondMaxNeg=maxNeg;
                maxNeg=a[i];
            } else if(a[i]<secondMaxNeg){
                secondMaxNeg=a[i];
            }
        }
        if(secondMax*max>maxNeg*secondMaxNeg){
            System.out.println(secondMax + " " + max);
        } else {
            System.out.println(secondMaxNeg + " " + maxNeg);
        }

    }


}
