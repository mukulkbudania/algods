package prep.interview.geeks.algo.backtracking;

import java.util.Arrays;

/**
 * Created by mukulbudania on 8/3/17.
 */
public class HamiltonionPath {
    public static void main(String[] args){
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0}
        };
        int[] path= new int[5];
        Arrays.stream(path).forEach(i->path[i]=-1);
        path[0]=0;
        if(getPath(graph, path, 1)){
            print(path);
        } else {
            System.out.println("No path");
        };
    }

    private static void print(int[] path) {
        Arrays.stream(path).forEach(s -> System.out.print(s + " "));
    }

    private static boolean getPath(int[][] graph, int[] path, int pos) {
        if(pos==5){
            if(graph[path[4]][0]==1) {
                return true;
            }
            else return false;
        } else {
            for(int val=0;val<5;val++){
                if(isSafe(graph,path,pos,val)){
                    path[pos]=val;
                    if(getPath(graph,path,pos+1))return true;
                    path[pos]=-1;
                }
            }
            return false;
        }
    }

    private static boolean isSafe(int[][] graph, int[] path, int pos,int val) {
        for(int i=0;i<pos;i++) if(path[i]==val) return false;
        if(graph[path[pos-1]][val]==0) return false;
        return true;
    }
}
