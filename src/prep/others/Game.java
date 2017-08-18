package prep.others;

import prep.interview.geeks.algo.backtracking.Permutation;
import prep.interview.geeks.ds.advanced.trie.Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by mukulbudania on 7/15/17.
 */
public class Game {

    private static final String FILENAME = "/Users/mukulbudania/Documents/words/english-words/words.txt";
    private static final String word = "";
    private static final int[] wordLengths = {3,4,5};
    private Trie trie = new Trie();


    private void buildTrie(){
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(FILENAME));
            String str;
            while ((str = in.readLine()) != null)
                trie.insert(str.trim().toLowerCase());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in !=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Trie getTrie() {
        return trie;
    }

    public static void main(String[] args){
        Game game = new Game();
        game.buildTrie();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        List<String> permutations = Permutation.getPermutations(word);
        Set<String> finalString = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length())return o1.length()-o2.length();
                return o1.compareTo(o2);
            }
        });
        for(String s: permutations) {
            List<String> prefix = new ArrayList<String>();
            for (int x = 3; x <= s.length(); x++) {
                prefix.add(s.substring(0, x));
            }
            for(String w: prefix)
                if (game.getTrie().exactSearch(w))
                    finalString.add(w);
        }
        for(String s: finalString){
            System.out.println(s);
        }
    }
}
