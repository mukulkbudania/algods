package prep.interview.geeks.algo.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class MinCostTraingulation {
    private static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public double getMinCost(List<Point> points){
        int n = points.size();
        double[][] dp = new double[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i]=0;
            dp[i][i+1]=0;
        }
        dp[n-1][n-1]=0;
        for(int size=3;size<=n;size++){
            for(int start=0;start<=n-size;start++){
                int end = start + size -1;
                double min = Integer.MAX_VALUE;
                for(int index=start+1;index<end;index++){
                    min = Math.min(min,dp[start][index] + dp[index][end] + cost(points,start,index,end));
                }
                dp[start][end] = min;
            }
        }
        return dp[0][n-1];
    }

    private double cost(List<Point> points, int start, int index, int end) {
        return distance(points.get(start),points.get(end)) + distance(points.get(index),points.get(end)) + distance(points.get(start),points.get(index));
    }

    private double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x-point2.x,2) + Math.pow(point1.y-point2.y,2));
    }
    public static void main(String[] args){
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0,0));points.add(new Point(1,0));
        points.add(new Point(2,1));points.add(new Point(1,2));
        points.add(new Point(0,2));
        System.out.println(new MinCostTraingulation().getMinCost(points));
    }
}
