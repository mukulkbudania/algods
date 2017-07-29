package prep.interview.geeks.companies.amazon.hard;

/**
 * Created by mukulbudania on 7/30/17.
 */
public class WaterOverflow {
    public static void main(String[] args){
        int i = 4, j = 2;
        double X = 15.0;
        System.out.println(getWater(i,j,X));
    }

    private static double getWater(int i, int j, double x) {
        int totalIndex = ((i+2)*(i+1))/2;
        double glass[] = new double[totalIndex];
        int index=0;
        glass[index]=x;
        for(int row=1;row<=i &&x!=0.0;row++){
            for(int col=1;col<=row;col++,++index){
                x=glass[index];
                if(x>1.0){
                    glass[index]=1;
                    x=x-1;
                } else {
                    glass[index]=x;
                    x = 0.0;
                }
                glass[index+row]+=x/2;
                glass[index+row+1]+=x/2;
            }
        }
        print(glass);
        return glass[(i*(i-1))/2+j-1];
    }

    private static void print(double[] glass) {
        for(int i=0;i<glass.length;i++)System.out.print(glass[i] + " ");
        System.out.println();
    }
}
