package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 * Make 2 aux arrays leftMax and rightMax. Water = min(leftMax,rightMax)-height
 */
public class TrappingRainWater {
    public static void main(String[] args){
        int a[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(getWater(a));
    }

    private static int getWater(int[] a) {
        int leftMax[] = new int[a.length];
        int rightMax[] = new int[a.length];
        leftMax[0]=a[0];
        for(int i=1;i<a.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],a[i]);
        }
        rightMax[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1],a[i]);
        }
        int water = 0;
        for(int i=0;i<a.length;i++){
            water+=Math.min(leftMax[i],rightMax[i])-a[i];
        }
        return water;
    }
}
