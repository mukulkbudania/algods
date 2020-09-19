package geeks.algo.dynamic;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class MaxSumDownPath {
    public static void main(String[] args){
        int a[][] = {{348, 391}, {618, 193}};
        System.out.println(getMax(a,2));
    }

    private static int getMax(int[][] a,int n) {
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int leftdiag=Integer.MIN_VALUE,rightdiag = Integer.MIN_VALUE;
                if(j!=0)leftdiag=a[i-1][j-1];
                if(j!=n-1)rightdiag=a[i-1][j+1];
                a[i][j] = a[i][j] + Math.max(Math.max(leftdiag, rightdiag), a[i - 1][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,a[n-1][i]);
        }
        return max;
    }
}
