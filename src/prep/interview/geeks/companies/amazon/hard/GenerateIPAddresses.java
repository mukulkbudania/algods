package prep.interview.geeks.companies.amazon.hard;

import java.util.ArrayList;

/**
 * Created by mukulbudania on 8/16/17.
 */
public class GenerateIPAddresses {
    public static ArrayList<String> genIp(String s){
        ArrayList<String> list = new ArrayList<String>();
        genIP(s,"",0,0,list);
        return list;
    }
    private static void genIP(String s,String ip,int start,int sofar, ArrayList<String> list){
        if(sofar == 4 && start == s.length()){
            list.add(ip.substring(1,ip.length()));
        }
        String tempIP = "";
        for(int i = start; i < start+3 && i < s.length(); i++){
            if(s.charAt(start) == '0' && i > start)
                continue;
            tempIP += s.charAt(i);
            if(Integer.parseInt(tempIP) <= 255){
                genIP(s,ip+"."+tempIP,i+1,sofar+1,list);
            }
        }
    }
}
