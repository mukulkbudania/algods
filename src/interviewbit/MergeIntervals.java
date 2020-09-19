package interviewbit;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukulbudania on 8/3/17.
 */
public class MergeIntervals {
    public static void main(String[] args){
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(6, 7));
        //intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        Interval newInterval = new Interval(6,10);
        MergeIntervals searchFloor = new MergeIntervals();
        List<Interval> newIntervals = searchFloor.insert(intervals, newInterval);
        for(Interval i:newIntervals){
            System.out.println(i + " ");
        }
    }

    private static class Interval {
        int start;
        int end;
        public Interval(int start, int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.start>newInterval.end){
            int temp = newInterval.end;
            newInterval.end=newInterval.start;
            newInterval.start=temp;
        }
        int i=0;
        while(i<intervals.size() && intervals.get(i).end<newInterval.start) i++;
        if(i==intervals.size() || intervals.get(i).start>newInterval.end){
            intervals.add(i,newInterval);
            return intervals;
        } else {
            intervals.get(i).start= Math.min(intervals.get(i).start, newInterval.start);
            intervals.get(i).end= Math.max(newInterval.end, intervals.get(i).end);
        }
        int x=i+1;
        while(x<intervals.size() && intervals.get(x).start<newInterval.end){
            intervals.get(i).start= Math.min(intervals.get(i).start, intervals.get(x).start);
            intervals.get(i).end= Math.max(intervals.get(i).end, intervals.get(x).end);
            x++;
        }
        while(x<intervals.size()){
            i++;
            intervals.set(i,intervals.get(x));
            x++;
        }
        while (x-->i+1){
            intervals.remove(x);
        }
        return intervals;
    }

}
