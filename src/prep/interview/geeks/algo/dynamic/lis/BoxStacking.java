package prep.interview.geeks.algo.dynamic.lis;

import org.omg.CORBA.portable.BoxedValueHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mukulbudania on 7/12/17.
 */
public class BoxStacking {
    private static class Box{
        int width;
        int length;
        int height;
        Box(int width,int length,int height){
            this.width=width;
            this.length=length;
            this.height=height;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("W: ");sb.append(width);
            sb.append(" L: ");sb.append(length);
            sb.append(" H: ");sb.append(height);
            sb.append("\n");
            return sb.toString();
        }
    }
    public static void main(String[] args){
        List<Box> boxes = new ArrayList<Box>(4);
        boxes.add(new Box(4,6,7));
        boxes.add(new Box(1,2,3));
        boxes.add(new Box(4,5,6));
        boxes.add(new Box(10,12,32));
        System.out.println("Maximum height possible: " + getMaxHeight(boxes));
    }

    private static int getMaxHeight(List<Box> initialBoxes) {
        int n= initialBoxes.size();
        List<Box> boxes = new ArrayList<Box>(3*n);
        for(Box b: initialBoxes){
            boxes.add(new Box(b.width,b.length,b.height));
            boxes.add(new Box(b.length,b.height,b.width));
            boxes.add(new Box(b.height,b.width,b.length));
        }
        boxes.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return o2.width * o2.length - o1.width * o1.length ;
            }
        });
        int maxHeight[] = new int[3*n];
        maxHeight[0]=boxes.get(0).height;
        for(int i=1;i<3*n;i++){
            maxHeight[i]=boxes.get(i).height;
            for (int j=0;j<i;j++){
                int boxJWidth = boxes.get(j).width;
                int boxJLength = boxes.get(j).length;
                int boxIWidth = boxes.get(i).width;
                int boxILength = boxes.get(i).length;
                System.out.println(boxJWidth + " " + boxJLength + " " + boxIWidth + " " + boxILength);
                if(max(boxJLength,boxJWidth)>max(boxILength,boxIWidth) &&
                        min(boxJLength, boxJWidth)>min(boxILength, boxIWidth) &&
                        maxHeight[i]<maxHeight[j] + boxes.get(i).height){
                    System.out.println("\t\tBoxJ "+ j + ": " + boxes.get(j));
                    maxHeight[i] = maxHeight[j] + boxes.get(i).height;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3*n;i++){
            if(maxHeight[i]>max){
                max=maxHeight[i];
            }
        }
        return max;
    }

    private static int min(int a, int b) {
        return (a>b)?b:a;
    }

    private static int max(int a, int b) {
        return (a>b)?a:b;
    }
}
