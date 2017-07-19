package prep.interview.geeks.companies.amazon;

import java.util.Scanner;

/**
 * Created by mukulbudania on 7/18/17.
 */
public class MaxSumRectangle {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for(int x=0;x<t;x++){
            int n = in.nextInt();
            int m = in.nextInt();
            in.nextLine();
            int a[][] = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j] = in.nextInt();
                }
            }
            in.nextLine();
            System.out.println(getMaxRectangle(a,n,m));
        }
    }

    private static Output2D getMaxRectangle(int[][] a,int n,int m) {
        Output2D output2D = new Output2D();
        for(int left=0;left<m;left++){
            int temp[] = new int[n];
            for(int right=left;right<m;right++){
                for(int i=0;i<n;i++){
                    temp[i]+=a[i][right];
                }
                Output1D output1D = getMaxLine(temp);
                if(output1D.getSum()>output2D.sum){
                    output2D.setStarti(output1D.getStart());
                    output2D.setEndi(output1D.getEnd());
                    output2D.setStartj(left);
                    output2D.setEndj(right);
                    output2D.setSum(output1D.getSum());
                }
            }
        }
        return output2D;
    }

    private static Output1D getMaxLine(int[] a) {
        Output1D output1D = new Output1D();
        int sumTillNow = 0;
        int start = 0;
        for(int i=0;i<a.length;i++){
            sumTillNow+=a[i];
            if(sumTillNow>output1D.getSum()){
                output1D.setSum(sumTillNow);
                output1D.setStart(start);
                output1D.setEnd(i);
            }
            if(sumTillNow<0){
                sumTillNow=0;
                start=i+1;
            }
        }
        return output1D;
    }

    private static class Output1D {
        private int start;
        private int end;
        private int sum;

        public Output1D() {
            start=-1;end=-1;
            sum=Integer.MIN_VALUE;
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

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Output1D{" +
                    "start=" + start +
                    ", end=" + end +
                    ", sum=" + sum +
                    '}';
        }
    }
    private static class Output2D {
        private int starti;
        private int startj;
        private int endi;
        private int endj;
        private int sum;

        public Output2D() {
            starti=startj=endi=endj=-1;
            sum=Integer.MIN_VALUE;
        }

        public int getStarti() {
            return starti;
        }

        public void setStarti(int starti) {
            this.starti = starti;
        }

        public int getStartj() {
            return startj;
        }

        public void setStartj(int startj) {
            this.startj = startj;
        }

        public int getEndi() {
            return endi;
        }

        public void setEndi(int endi) {
            this.endi = endi;
        }

        public int getEndj() {
            return endj;
        }

        public void setEndj(int endj) {
            this.endj = endj;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Output{" +
                    "starti=" + starti +
                    ", startj=" + startj +
                    ", endi=" + endi +
                    ", endj=" + endj +
                    ", sum=" + sum +
                    '}';
        }
    }
}
