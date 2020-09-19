package geeks.companies.amazon.hard;

/**
 * Created by mukulbudania on 8/2/17.
 */
public class RobotMotion {
    public static void main(String[] args){
        String arr = "GGGGL";
        System.out.println(isBack(arr));
    }

    private static boolean isBack(String arr) {
        int dir=0;int posX=0;int posY=0;
        for(int i=0;i<arr.length();i++){
            if(arr.charAt(i)=='L'){
                dir=(dir+1)%4;
            } else if(arr.charAt(i)=='R'){
                dir=(dir-1)%4;
            } else {
                switch (dir){
                    case 0: posX++;break;
                    case 1: posY++;break;
                    case 2: posX--;break;
                    case 3: posY--;break;
                }
            }
        }
        return (posX==0 && posY==0);
    }
}