package geeks.ds.heap;

/**
 * Created by mukulbudania on 7/27/17.
 */
public class MedianInAStream {
    private static Heap minHeap = new Heap(20, (a, b) -> {if(a>b)return 1;if(a<b)return -1;return 0;});
    private static Heap maxHeap = new Heap(20, (a, b) -> {if(a>b)return -1;if(a<b)return 1;return 0;});
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1};
        for(int i=0;i<a.length;i++){
            System.out.println(getMedian(a[i]));
        }
    }

    private static double getMedian(int i) {
        if(minHeap.getSize()==maxHeap.getSize()){
            if(i>minHeap.getTop()){
                minHeap.insert(i);
                return minHeap.getTop();
            } else {
                maxHeap.insert(i);
                return maxHeap.getTop();
            }
        } else if (minHeap.getSize()>maxHeap.getSize()){
            if(i>minHeap.getTop()){
                int val = minHeap.extractTop();
                maxHeap.insert(val);
                minHeap.insert(i);
                return (minHeap.getTop() + maxHeap.getTop())/2.0;
            } else {
                maxHeap.insert(i);
                return (minHeap.getTop() + maxHeap.getTop())/2.0;
            }
        } else {
            if(i>minHeap.getTop()){
                minHeap.insert(i);
                return (minHeap.getTop() + maxHeap.getTop())/2.0;
            } else {
                int val = maxHeap.extractTop();
                minHeap.insert(val);
                maxHeap.insert(i);
                return (minHeap.getTop() + maxHeap.getTop())/2.0;
            }
        }
    }
}