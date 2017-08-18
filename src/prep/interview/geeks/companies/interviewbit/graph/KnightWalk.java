package prep.interview.geeks.companies.interviewbit.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class KnightWalk {
    private static Pair NULL_PAIR = new Pair(-1,-1);
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        if(x1==x2 && y1==y2)return 0;
        int moves[][] = {
                {-2,-1,1,2,-2,-1,1,2},
                {-1,-2,2,1,1,2,-2,-1}
        };
        boolean[][] visited= new boolean[N][M];
        for(int i=0;i<N;i++)for(int j=0;j<M;j++)visited[i][j]=false;
        int hops=1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x1-1, y1-1));queue.add(NULL_PAIR);
        while(!queue.isEmpty()){
            Pair position = queue.poll();
            if(position.equals(NULL_PAIR)){
                hops++;
                if(queue.isEmpty()) return -1;
                queue.add(NULL_PAIR);
            } else {
                for(int i=0;i<8;i++){
                    int newPx = position.x + moves[0][i];
                    int newPy = position.y + moves[1][i];
                    if(newPx==x2-1 && newPy==y2-1) return hops;
                    if(isValid(visited,newPx,newPy,N,M)){
                        queue.add(new Pair(newPx,newPy));
                        visited[newPx][newPy]=true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(boolean[][] visited, int i, int j, int n, int m) {
        return (i>=0 && i<n && j>=0 && j<m && !visited[i][j]);
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            if (y != pair.y) return false;

            return true;
        }
    }
}
