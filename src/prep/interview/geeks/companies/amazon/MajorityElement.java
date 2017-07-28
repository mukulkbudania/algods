package prep.interview.geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/28/17.
 */
public class MajorityElement {
    public static void main(String[] args){
        int a[] = {1,3,2,1,3,3,3,2,1,3,3,3};
        System.out.println(getMajorityElement(a));
    }

    private static int getMajorityElement(int[] a) {
        if(a.length==0)return -1;
        int result = a[0];int count=1;
        for(int i=1;i<a.length;i++){
            if(a[i]==result)count++;
            else count--;
            if(count==0) {result=a[i];count=1;}
        }
        count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==result)count++;
        }
        if(count<=a.length/2)return -1;
        else return result;
    }
}
