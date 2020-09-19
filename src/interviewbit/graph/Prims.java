package interviewbit.graph;

import java.util.*;

/**
 * Created by mukulbudania on 8/5/17.
 */
public class Prims {
    private class Edge{
        int start;
        int end;
        int weight;
        public Edge(int start,int end,int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int set[] = new int[A+1];
        for(int i=1;i<=A;i++){
            set[i]=i;
        }
        List<Edge> edges = new ArrayList<Edge>(B.size());
        for(ArrayList<Integer> edge: B){
            int min = Math.min(edge.get(0), edge.get(1));
            int max = edge.get(0)+edge.get(1)-min;
            edges.add(new Edge(min,max,edge.get(2)));
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight-o2.weight;
            }
        });

        int sum=0;int count=0;
        for(Edge e: edges){
            if(set[e.start]!=set[e.end]){
                sum+=e.weight;
                int min=Math.min(set[e.start],set[e.end]);
                int max=Math.max(set[e.start],set[e.end]);
                for(int i=max;i<=A;i++){
                    if(set[i]==max)set[i]=min;
                }
                count++;
                if(count==A-1)break;
            }
        }
        return sum;
    }

    private void print(List<Edge> edges) {
        for(Edge edge: edges){
            System.out.println("S: " + edge.start + "E: " + edge.end + "W: " + edge.weight);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int p = in.nextInt();
        int q = in.nextInt();
        ArrayList<ArrayList<Integer>> input = new ArrayList<>(p);
        for(int i=0;i<p;i++){
            ArrayList<Integer> list = new ArrayList<>(q);
            for(int j=0;j<q;j++){
                list.add(in.nextInt());
            }
            input.add(list);
        }
        System.out.println(new Prims().solve(n, input));
    }
}
