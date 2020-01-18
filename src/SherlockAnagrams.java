
public class SherlockAnagrams {

    static int sherlockAndAnagrams(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int y = i + 1; y <= s.length(); y++) {

                if (i >= y) throw new RuntimeException();

                int[] signatureA = getSignature(i, y, s);

                int size = y - i;

                for (int j = i; j <= s.length() - size; j++) {
                    int w = j + size;

                    if (i == j && y == w) continue;

                    int[] signatureB = getSignature(j, w, s);

                    if (isAnagram(signatureA, signatureB)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static boolean isAnagram(int[] signatureA, int[] signatureB) {
        if (signatureA.length != signatureB.length)
            throw new RuntimeException("wtf");

        for (int i = 0; i < signatureA.length; i++)
            if (signatureA[i] != signatureB[i])
                return false;

        return true;
    }

    private static int[] getSignature(int i, int y, String s) {
        int[] signature = new int[26];

        for (int j = i; j < y; j++)
            signature[s.charAt(j) - 'a']++;

        return signature;
    }


    public static void main(String[] args) {


        System.out.println("5: " + sherlockAndAnagrams("abba"));
        System.out.println("10: " + sherlockAndAnagrams("kkkk"));
    }

}
