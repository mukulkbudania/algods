package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class IsSudokuValid {
    public static void main(String[] args){
        int a[][] = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        System.out.println(isValid(a));

    }

    private static boolean isValid(int[][] a) {
        for(int i=0;i<9;i++){
            if(!checkRow(a,i))return false;
        }
        for(int i=0;i<9;i++){
            if(!checkCol(a,i)) return false;
        }
        for(int i=0;i<9;i++){
            if(!checkBox(a, i)) return false;
        }
        return true;
    }

    private static boolean checkBox(int[][] a, int b) {
        boolean arr[] = {false,false,false,false,false,false,false,false,false};
        int r = (b)/3;
        int c = (b)%3;
        for(int i=r*3,j=0;j<3;i++,j++){
            for(int k=c*3,l=0;l<3;k++,l++){
                if(a[i][k]==0) continue;
                if(!arr[a[i][k]-1])arr[a[i][k]-1]=true;
                else return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int a[][], int c) {
        boolean arr[] = {false,false,false,false,false,false,false,false,false};
        for(int i=0;i<9;i++) {
            if(a[i][c]==0)continue;
            if(!arr[a[i][c]-1])arr[a[i][c]-1]=true;
            else return false;
        }
        return true;
    }

    private static boolean checkRow(int[][] a, int r) {
        boolean arr[] = {false,false,false,false,false,false,false,false,false};
        for(int i=0;i<9;i++){
            if(a[r][i]==0)continue;
            if(!arr[a[r][i]-1])arr[a[r][i]-1]=true;
            else return false;
        }

        return true;
    }
}
