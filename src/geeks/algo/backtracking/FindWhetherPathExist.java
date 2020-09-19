package geeks.algo.backtracking;

import java.util.*;

/**
 * Created by mukulbudania on 8/3/17.
 * A value of cell 1 means Source.
 * A value of cell 2 means Destination.
 * A value of cell 3 means Blank cell.
 * A value of cell 0 means Blank Wall.
 */
public class FindWhetherPathExist {
    public static void main(String[] args) {
        int a[][] = {{0, 3, 1, 0},
                     {3, 0, 3, 3},
                     {2, 3, 0, 3},
                     {0, 3, 3, 3}};

        Set<Pair> path = new LinkedHashSet<>();
        int startx = -1;int starty = -1;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]==1){
                    startx=i;starty=j;
                    break;
                }
            }
        }
        checkPathExists(a, path, startx, starty);
    }

    private static boolean checkPathExists(int[][] a, Set<Pair> path,int nextx, int nexty) {
        if(nextx<0 || nexty<0 || nextx>=4 || nexty>=4) return false;
        Pair pair = new Pair(nextx,nexty);
        if(a[nextx][nexty]==2) {
            path.add(pair); print(path); return true;
        } else {
            if(isSafe(a,path,pair)){
                path.add(pair);
                if(checkPathExists(a,path,nextx+1,nexty))return true;
                if(checkPathExists(a,path,nextx,nexty+1))return true;
                if(checkPathExists(a,path,nextx-1,nexty))return true;
                if(checkPathExists(a,path,nextx,nexty-1))return true;
                path.remove(pair);
            }
            return false;
        }

    }

    private static boolean isSafe(int[][] a, Set<Pair> path,Pair pair) {
        if(a[pair.i][pair.j]==0) return false;
        if(path.contains(pair)) return false;
        return true;
    }

    private static void print(Set<Pair> path) {
        path.stream().forEach(s-> System.out.println(s));
    }

    private static class Pair {
        private int i;
        private int j;
        public Pair(int i, int j) {
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            if (j != pair.j) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

        @Override
        public String toString() {
            return "{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}
