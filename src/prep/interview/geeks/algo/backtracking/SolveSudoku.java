package prep.interview.geeks.algo.backtracking;

/**
 * Created by mukulbudania on 8/3/17.
 */
public class SolveSudoku {
    public static void main(String[] args){
        int a[][] ={
                {-1,-1,9,7,4,8,-1,-1,-1},
                {7,-1,-1,-1,-1,-1,-1,-1,-1},
                {-1,2,-1,1,-1,9,-1,-1,-1},
                {-1,-1,7,-1,-1,-1,2,4,-1},
                {-1,6,4,-1,1,-1,5,9,-1},
                {-1,9,8,-1,-1,-1,3,-1,-1},
                {-1,-1,-1,8,-1,3,-1,2,-1},
                {-1,-1,-1,-1,-1,-1,-1,-1,6},
                {-1,-1,-1,2,7,5,9,-1,-1}
        };
        solveSudoku(a);
        print(a);

    }

    private static void print(int[][] a) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(a[i][j] + " ") ;
            }
            System.out.println();
        }
    }

    private static void solveSudoku(int[][] a) {
        solveSudokuUtil(a, 0, 0);
    }

    private static boolean solveSudokuUtil(int[][] a, int row, int col) {
        //System.out.println(row + " " + col);
        if(col==9){ row++; col=0; }
        if(row==9) return true;
        if(a[row][col]!=-1) return solveSudokuUtil(a,row,col+1);
        for(int val=1;val<=9;val++){
            if(isSafe(a,row,col,val)){
                a[row][col]=val;
                //print(a);
                if(solveSudokuUtil(a,row,col+1))return true;
                a[row][col]=-1;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] a, int row, int col, int val) {
        for(int i=0;i<9;i++){
            if(val==a[i][col])return false;
        }
        for(int i=0;i<9;i++){
            if(val==a[row][i])return false;
        }
        int boxi=3*(row/3);
        int boxj=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(val==a[boxi+i][boxj+j]) return false;
            }
        }
        return true;
    }
}
