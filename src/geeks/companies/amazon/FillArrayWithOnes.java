package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class FillArrayWithOnes {
    public static void main(String[] args){
        int[] a = {0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1};
        System.out.println(getMaxFlips(a));
    }

    private static int getMaxFlips(int[] a) {
        int i=0;
        int j=a.length-1;
        while (i<a.length && a[i++]==0){}
        if(i==a.length) return -1;
        int firstCounter = i-1;
        while (j>=0 && a[j--]==0){}
        int lastCounter = a.length-1-j;
        int midCounter = 0;
        int maxMidCounter = 0;
        while (i<j){
            i++;j--;
            if(a[i]==0){
                midCounter++;
                maxMidCounter=Math.max(maxMidCounter,midCounter);
            } else {
                midCounter=0;
            }
        }
        return Math.max(Math.max(firstCounter, lastCounter), (maxMidCounter + 1) / 2);
    }
}
