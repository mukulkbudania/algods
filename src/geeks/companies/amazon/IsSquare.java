package geeks.companies.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class IsSquare {
    public static void main(String[] args){
        List<Point> points = new ArrayList<>();
        points.add(new Point(20,10));
        points.add(new Point(10,20));
        points.add(new Point(20,20));
        points.add(new Point(10,10));
        System.out.println(getIsSquare(points));

    }

    private static boolean getIsSquare(List<Point> points) {
        Map<Double,Integer> freqMap = new TreeMap<>();
        for(int i =0;i<points.size()-1;i++){
            for(int j=i+1;j<points.size();j++){
                double distance = points.get(j).distance(points.get(i));
                if(freqMap.containsKey(distance)){
                    freqMap.put(distance,freqMap.get(distance)+1);
                } else {
                    freqMap.put(distance,1);
                }
            }
        }
        if(freqMap.size()>2) return false;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(Double d:freqMap.keySet()){
            min=Math.min(min,d);
            max=Math.max(max,d);
        }
        if(freqMap.get(max)!=2)return false;
        if(freqMap.get(min)!=4)return false;
        return true;
    }

    private static class Point {
        private int x;
        private int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        double distance(Point y){
            return Math.sqrt((this.x-y.x)*(this.x-y.x) + (this.y-y.y)*(this.y-y.y));
        }
    }
}
