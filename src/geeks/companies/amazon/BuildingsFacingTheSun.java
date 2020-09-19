package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class BuildingsFacingTheSun {
    public static void main(String[] args){
        int a[] = {7, 4, 8, 2, 9};
        System.out.println(getMaxFacing(a));
    }

    private static int getMaxFacing(int[] a) {
        int max=a[0];int result=1;
        for(int i=1;i<a.length;i++){
            int val=max;
            max = Math.max(val,a[i]);
            if(max!=val)result++;
        }
        return result;
    }
}
