package prep.interview.geeks.algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class OverlappingIntervals {
    private static class Interval{
        private int start;
        private int end;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (end != interval.end) return false;
            if (start != interval.start) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" + + start +
                    "," + end +
                    '}';
        }
    }
    public static void main(String[] args){
        List<Interval> intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1,3));
        intervalList.add(new Interval(2,6));
        intervalList.add(new Interval(8,10));
        intervalList.add(new Interval(15,18));
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart()-o2.getStart();
            }
        });
        List<Interval> finalList = new ArrayList<>();
        finalList.add(intervalList.get(0));
        int size=0;
        for(int i=1;i< intervalList.size(); i++){
            Interval interval1 = finalList.get(size);
            Interval interval2 = intervalList.get(i);
            if(interval1.getEnd()>interval2.getStart()){
                interval1.setEnd(Math.max(interval1.getEnd(), interval2.getEnd()));
            } else {
                finalList.add(interval2);size++;
            }
        }
        print(finalList);
    }

    private static void print(List<Interval> finalList) {
        for(Interval interval: finalList){
            System.out.print(interval + " ");
        }
        System.out.println();
    }
}
