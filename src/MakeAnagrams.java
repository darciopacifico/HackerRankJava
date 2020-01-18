import java.io.IOException;

public class MakeAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {


        int[] freq = new int[26];

        for (int i = 0; i < a.length(); i++)
            freq[a.charAt(i) - 'a']++;


        for (int i = 0; i < b.length(); i++)
            freq[b.charAt(i) - 'a']--;

        int res = 0;
        for (int i = 0; i < freq.length; i++) {

            res = res + Math.abs(freq[i]);
        }

        return res;
    }


    public static void main(String[] args) throws IOException {

        System.out.println("must be 4 " + makeAnagram("showman", "woman"));

    }
}
