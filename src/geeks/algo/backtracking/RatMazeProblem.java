package geeks.algo.backtracking;

/**
 * Created by mukulbudania on 7/23/17.
 */
public class RatMazeProblem {
    public static void main(String[] args){

        int a[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {0,1,0,0},
                {1,1,1,1}
        };
        solve(a,4,4);
    }

    private static boolean solve(int[][] a,int n, int m) {
        int[][] solution = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                solution[i][j] = 0;
            }
        }
        if(solve(a,solution,0,0,n,m)){
            print(solution,n,m);
            return true;
        }
        return false;
    }

    private static void print(int[][] solution,int n,int m) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] a, int[][] solution, int i, int j,int n, int m) {
        if(i==n-1 && j==m-1){
            solution[i][j]=1;return true;
        }
        if(isValid(a,i,j,n,m)){
            solution[i][j]=1; // set
            if(solve(a,solution,i+1,j,n,m))return true; //check if a solution exists for possible moves.
            if(solve(a,solution,i,j+1,n,m))return true;
            solution[i][j]=0; //revert
            return false;
        }
        return false;
    }

    private static boolean isValid(int[][] a, int i, int j, int n, int m) {
        if(i<0 || i>=n || j<0 || j>=m || a[i][j]==0) return false;
        return true;
    }
}
