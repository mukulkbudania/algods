package prep.interview.geeks.ds.arrays;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class SearchInRotated {
    public static void main(String[] args){
        int a[] = {1,2,3,4,5,6};
        System.out.println(search(a, 1, 0, 5));
    }

    private static int search(int[] a, int element, int start, int end) {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(a[mid]==element) return mid;
        if(a[start]<a[mid]){
            //First half sorted
            if(element<a[start]){
               return search(a,element,mid+1,end);
            } else {
               return search(a,element,start,mid-1);
            }
        } else {
            if(a[end]<element){
                return search(a,element,start,mid-1);
            } else {
                return search(a,element,mid+1,end);
            }
        }
    }
}
