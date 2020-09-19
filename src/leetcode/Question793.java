package leetcode;

public class Question793 {
    public static void main(final String[] args){
        System.out.println(new Question793().preimageSizeFZF(50));
    }
    int preimageSizeFZF(int K) {
        if(K == 0)
        {
            return 5;
        }
        final int[] b = {1,6, 31, 156,781,  3906,19531,97656,  488281,2441406,12207031, 61035156, 305175781};
        int j = 0;
        for (int i = 0; i < 13; ++i) {
            if(K < b[i])
            {
                j = i - 1;
                break;
            }
        }
        while (K>0)
        {
            if(K != b[j] * 5)
            {
                K = K - (K/b[j] * b[j]);
                --j;
            } else{
                return 0;
            }
        }
        return 5;
    }
}
