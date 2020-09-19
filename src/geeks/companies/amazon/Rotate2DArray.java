package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class Rotate2DArray {
    public static void main(String[] args){
        int a[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        rotate(a,4);
        print(a,4);
    }

    private static void print(int[][] a,int n) {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotate(int[][] a,int n) {
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int temp = a[i][j];
                a[i][j]=a[n-1-j][i];
                a[n-1-j][i]=a[n-1-i][n-1-j];
                a[n-1-i][n-1-j]=a[j][n-1-i];
                a[j][n-1-i]=temp;
            }
        }
    }
}
