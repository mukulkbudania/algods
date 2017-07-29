package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class LargestSquareInMatrix {
    public static void main(String[] args){
        int a[][] = {
            {0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1}
        };
        System.out.println(sum(a,5,6));
    }

    private static int sum(int[][] a,int n, int m) {
        int max = 0;
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
            if(a[i][j]==1){
                a[i][j] = 1 + Math.min(Math.min(a[i-1][j],a[i][j-1]),a[i-1][j-1]);
                max = Math.max(max,a[i][j]);
            }
        return max;
    }
}
