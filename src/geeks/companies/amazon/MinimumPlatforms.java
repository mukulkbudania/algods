package geeks.companies.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class MinimumPlatforms {
    public static void main(String[] args){
        int a[] = {900, 940, 950, 1100, 1500, 1800};
        int b[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(getMinPlatforms(a,b));
    }

    private static int getMinPlatforms(int[] a, int[] b) {
        List<TimePoint> points = new ArrayList<>(2*a.length);
        for(int i=0;i<a.length;i++) points.add(new TimePoint(a[i],true));
        for(int i=0;i<b.length;i++) points.add(new TimePoint(b[i],false));
        Collections.sort(points, new Comparator<TimePoint>() {
            @Override
            public int compare(TimePoint o1, TimePoint o2) {
                int x = o1.getTime()-o2.getTime();
                if(x!=0)return x;
                if(o1.isIncoming()==false && o2.isIncoming()==true)return -1;
                if(o1.isIncoming()==true && o2.isIncoming()==false) return 1;
                return 0;
            }
        });

        int minPlatforms = 0,platforms=0;
        for(TimePoint p: points){
            if(p.isIncoming()){
                platforms++;
                minPlatforms=Math.max(minPlatforms,platforms);
            } else {
                platforms--;
            }
        }
        return minPlatforms;
    }

    private static class TimePoint {
        private int time;
        private boolean incoming;
        public TimePoint(int time,boolean incoming){
            this.time=time;
            this.incoming = incoming;
        }

        public int getTime() {
            return time;
        }

        public boolean isIncoming() {
            return incoming;
        }
    }
}
