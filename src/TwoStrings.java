import java.nio.CharBuffer;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {


        Set<Integer> ss1 = toSet(s1);

        Set<Integer> ss2 = toSet(s2);

        return ss1.stream().anyMatch(v -> ss2.contains(v)) ? "YES" : "NO";
    }

    private static Set<Integer> toSet(String s1) {
        Set<Integer> ss1 = CharBuffer.wrap(s1.toCharArray()).chars().boxed().collect(Collectors.toSet());
        return ss1;
    }

    public static void main(String[] args) {


        System.out.println(twoStrings("hello", "world"));

        System.out.println(twoStrings("hi", "world"));
    }
}
