import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StringSimilarities {

    static long stringSimilarity(final String ss) {
        String zs = ss + "$" + ss;

        long[] z = new long[zs.length()];

        getZarr(zs, z);

        long[] zzz = Arrays.copyOfRange(z, ss.length() + 1, z.length);

        long c = Arrays.stream(zzz).sum();


        return c;

    }

    public static void search(String text, String pattern) {

        // Create concatenated string "P$T"
        String concat = pattern;

        int l = concat.length();

        long Z[] = new long[l];

        // Construct Z array
        getZarr(concat, Z);


        // now looping through Z array for matching condition
        for (int i = 0; i < l; ++i) {

            // if Z[i] (matched region) is equal to pattern
            // length we got the pattern

            if (Z[i] == pattern.length()) {
                System.out.println("Pattern found at index "
                        + (i - pattern.length() - 1));
            }
        }
    }

    // Fills Z array for given string str[]
    private static void getZarr(String str, long[] Z) {

        long n = str.length();

        // [L,R] make a window which matches with
        // prefix of s
        int L = 0, R = 0;

        for (int i = 1; i < n; ++i) {

            // if i>R nothing matches so we will calculate.
            // Z[i] using naive way.
            if (i > R) {

                L = R = i;

                // R-L = 0 in starting, so it will start
                // checking from 0'th index. For example,
                // for "ababab" and i = 1, the value of R
                // remains 0 and Z[i] becomes 0. For string
                // "aaaaaa" and i = 1, Z[i] and R become 5

                while (R < n && str.charAt(R - L) == str.charAt(R))
                    R++;

                Z[i] = R - L;
                R--;

            } else {

                // k = i-L so k corresponds to number which
                // matches in [L,R] longerval.
                int k = i - L;

                // if Z[k] is less than remaining longerval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3, R = 5
                // and L = 2
                if (Z[k] < R - i + 1)
                    Z[i] = Z[k];

                    // For example str = "aaaaaa" and i = 2, R is 5,
                    // L is 0
                else {


                    // else start from R and check manually
                    L = i;
                    while (R < n && str.charAt((int) (R - L)) == str.charAt((int) R))
                        R++;

                    Z[i] = R - L;
                    R--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {


        System.out.println(" must be 13 : " + stringSimilarity("abcabccba"));

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/darciopacifico/Documents/HackerhankJava/src/casePrefix.txt")));

        long[] res = new long[]{
                3460612557l,
                4119297033l,
                3938702989l,
                3083641614l,
                1704340099,
                560269674,
                35107137,
                332233480,
                1844721857,
                4248292
        };

        for (int i = 0; i < res.length; i++) {
            String line = br.readLine();
            System.out.println(" must be " + res[i] + ": " + stringSimilarity(line));
        }


    }
}
