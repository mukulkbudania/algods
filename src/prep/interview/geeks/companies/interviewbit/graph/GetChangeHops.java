package prep.interview.geeks.companies.interviewbit.graph;

import java.util.*;

/**
 * Created by mukulbudania on 8/6/17.
 */
public class GetChangeHops {

    List<List<Integer>> graph = null;

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        int n=dict.size();
        buildGraph(dict);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> pathTillNow = new ArrayList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        doDFS(n-2,n-1,visited,pathTillNow,result);
        ArrayList<ArrayList<String>> stringResult = new ArrayList<>();
        for(List<Integer> a: result){
            ArrayList<String> strings = new ArrayList<>();
            for(int x:a){
                strings.add(dict.get(x));
            }
            stringResult.add(strings);
        }
        return stringResult;
    }
    public void buildGraph(List<String> list){
        int n = list.size();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(check(list,i,j)){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        this.graph=graph;
    }

    public void doDFS(int start, int end, boolean[] visited,ArrayList<Integer> pathTillNow,ArrayList<ArrayList<Integer>>result){
        pathTillNow.add(start);
        visited[start]=true;
        if(start==end){
            result.add(new ArrayList<Integer>(pathTillNow));
        }
        for(int i:graph.get(start)){
            if(!pathTillNow.contains(i)){
                doDFS(i,end,visited,pathTillNow,result);
            }
        }
        pathTillNow.remove(start);
        visited[start]=false;
    }
    public boolean check(List<String> list,int i,int j){
        String x1 = list.get(i);
        String x2 = list.get(j);
        if(x1.length()!=x2.length())return false;
        boolean change=false;
        for(int x=0;x<x1.length();x++){
            if(x1.charAt(x)!=x2.charAt(x)){
                if(change) return false;
                else change=true;
            }
        }
        return change;
    }

    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        if(start.equals(end))return 0;
        int n=dictV.size();
        buildGraph(dictV);
        return doBFS(n-2,n-1);
    }

    public int doBFS(int start,int end){
        int n = graph.size();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        q.add(start);q.add(-1);
        visited[start]=true;
        int hops=1;
        while(!q.isEmpty()){
            int x = q.poll();
            if(x==-1){
                hops++;
                if(q.isEmpty()) break;
                q.add(-1);
            } else {
                for(int i:graph.get(x)) {
                    if(i==end) return hops+1;
                    if(!visited[i]){visited[i]=true;q.add(i);}
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        ArrayList<String> dictionary = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            dictionary.add(line[i]);
        }
        System.out.println(new GetChangeHops().findLadders(dictionary.get(n-2),dictionary.get(n-1),dictionary));
    }
}
