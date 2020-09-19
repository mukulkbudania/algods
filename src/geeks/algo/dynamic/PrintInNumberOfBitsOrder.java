package geeks.algo.dynamic;

/**
 * Created by mukulbudania on 8/30/17.
 */
public class PrintInNumberOfBitsOrder {
    void printInOrder(int n){
        for(int i=1;i<=n;i++){
            print("",i,n);
            System.out.println();
        }
    }
    private void print(String s, int i, int n) {
        int len = s.length();
        if(len==n) {
            System.out.print(s + " ");
            return;
        }
        if(i!=0) print("1"+s,i-1,n);
        if(n-len>i)print("0"+s,i,n);
    }
    public static void main(String[] args){
        new PrintInNumberOfBitsOrder().printInOrder(5);
    }
}
