package prep.interview.geeks.algo.backtracking;

/**
 * Created by mukulbudania on 8/2/17.
 */
public class NQueenProblem {
    public static void main(String[] args){
        solveNQueen();
    }

    private static void solveNQueen() {
        boolean a[][] = {
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false},
                {false,false,false,false,false,false,false,false,false}
        };

        System.out.println(solveNQueenUtil(a, 0));
        print(a);
    }

    private static boolean solveNQueenUtil(boolean[][] a, int row) {
        if(row>=9) {
            return true;
        }
        for(int col=0;col<9;col++){
            if(isSafe(a,row,col)){
                a[row][col]=true;
                if(solveNQueenUtil(a, row + 1)) return true;
                a[row][col]=false;
            }
        }
        return false;
    }

    private static boolean isSafe(boolean[][] a, int row, int col) {
        for(int i=0;i<row;i++){
            if(a[i][col]) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
                if(a[i][j]) return false;
        }
        for(int i=row,j=col;i>=0 && j<9;i--,j++){
            if(a[i][j]) return false;
        }
        return true;
    }

    private static void print(boolean[][] a) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print((a[i][j]?1:0) + " ");
            }
            System.out.println();
        }
    }
}
