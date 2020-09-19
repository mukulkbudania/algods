package prep.interview.geeks.companies.facebook;

public class TrailZerosFactorial {
    public static void main(final String[] args){
        System.out.println(new TrailZerosFactorial().trailingZeroes(25));
    }
    public int trailingZeroes(int a) {
        if(a==0) return 1;
        int x = 0;
        while(a>0){
            a = a/5;
            x+=a;
        }
        return x;
    }
}
