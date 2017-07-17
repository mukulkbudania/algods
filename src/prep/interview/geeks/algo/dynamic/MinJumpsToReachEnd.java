package prep.interview.geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/17/17.
 */
public class MinJumpsToReachEnd {
    public static void main(String[] args){
        int a[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minHopsToReachEnd(a));
    }

    /**
     * Keep on moving the pointer from left to right and updating max reach. once u reach the end of step. increase the jump.
     * Usecases: When we reach a point which is not reachable or is starting point is blocked return -1,
     * @param arr
     * @return
     */
    private static int minHopsToReachEnd(int[] arr) {
        if(arr.length<=1) return 1;
        if(arr[0]==0) return -1;
        int maxReach = arr[0];
        int step = arr[0];
        int jump=1;
        for(int i=1;i<arr.length;i++){
            if(i==arr.length-1) return jump;
            maxReach = Math.max(maxReach,i+arr[i]);
            step--;
            while(step==0){
                jump++;
                if(i>=maxReach) return -1;
                step=maxReach-i;
            }
        }
        return -1;
    }
}
