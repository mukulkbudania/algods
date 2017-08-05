package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 8/1/17.
 */
public class OverlappingRectangles {
    public static void main(String[] args){
        Rectangle r1 = new Rectangle(new Point(2,6),new Point(5,3));
        Rectangle r2 = new Rectangle(new Point(2,9),new Point(6,3));
        System.out.println(isOverlapping(r1, r2));
    }

    private static boolean isOverlapping(Rectangle r1, Rectangle r2) {
        if(r1.rightBottom.x<r2.leftTop.x || r2.rightBottom.x<r1.leftTop.x) return false;
        if(r1.leftTop.y<r2.rightBottom.y || r2.leftTop.y<r1.rightBottom.y) return false;
        return true;
    }

    private static class Rectangle {
        Point leftTop;
        Point rightBottom;
        Rectangle(Point leftTop, Point rightBottom){
            this.leftTop=leftTop;
            this.rightBottom=rightBottom;
        }
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
