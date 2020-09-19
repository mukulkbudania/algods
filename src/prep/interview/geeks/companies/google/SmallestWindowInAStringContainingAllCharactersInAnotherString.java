package prep.interview.geeks.companies.google;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string/1
 */
public class SmallestWindowInAStringContainingAllCharactersInAnotherString {

    public static void main() {
        final SmallestWindowInAStringContainingAllCharactersInAnotherString classToTest = new SmallestWindowInAStringContainingAllCharactersInAnotherString();
        final Scanner in = new Scanner(System.in);
        final int noOfCases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < noOfCases; i++) {
            final String stringToSearchIn = in.nextLine();
            final String stringToSearch = in.nextLine();
            final String result = classToTest.getSmallestWindow(stringToSearchIn, stringToSearch);
            System.out.println(result);
        }
    }

    /*
        Find the hash of String

     */
    public String getSmallestWindow(final String stringToSearchIn,
                                    final String stringToSearch) {

        return null;
    }
}
