package geeks.companies.amazon;

/**
 * Created by mukulbudania on 7/29/17.
 */
public class AngleBetweenHourAndMinute {
    public static void main(String[] args){
        int h = 3;
        int m = 30;
        System.out.println(Math.abs((30*h)+m/2.0 - 6*m));
    }
}
