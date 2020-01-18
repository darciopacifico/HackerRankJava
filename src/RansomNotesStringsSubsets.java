import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNotesStringsSubsets {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        System.out.println(checkMagazineB(magazine, note) ? "Yes" : "No");
    }

    static boolean checkMagazineB(String[] magazine, String[] note) {

        Map<String, Integer> wordCountM = wordCount(magazine);
        Map<String, Integer> wordCountN = wordCount(note);

        for (Map.Entry<String, Integer> word : wordCountN.entrySet()) {

            Integer newNal = wordCountM.compute(word.getKey(), (k, v) -> {
                if (v == null) return -1;
                return v - word.getValue();
            });

            if (newNal < 0)
                return false;

        }

        return true;
    }

    private static Map<String, Integer> wordCount(String[] magazine) {
        Map<String, Integer> wordCount = new HashMap<>();
        Arrays.stream(magazine).forEach(word -> {
                    wordCount.putIfAbsent(word, 0);
                    wordCount.merge(word, 1, (a, b) -> a + b);
                }
        );
        return wordCount;
    }


    public static void main(String[] args) {
        System.out.println("false :" + checkMagazineB(
                "two times three is not four".split(" "),
                "two times two is four".split(" ")));


        System.out.println("true :" + checkMagazineB(
                "give me one grand today night".split(" "),
                "give one grand today".split(" ")));

        System.out.println("false :" + checkMagazineB(
                "ive got a lovely bunch of coconuts".split(" "),
                "ive got some coconuts".split(" ")));

    }
}
