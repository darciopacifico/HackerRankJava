import java.io.IOException;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long aCount = s.chars().mapToObj(c -> (char) c).filter(c -> c == 'a').count();

        long fullAsString = n / s.length();

        long lastStringUpTo = n % s.length();

        long asUpTo = asUpTo(s, lastStringUpTo);

        return (fullAsString * aCount) + asUpTo;

    }

    private static long asUpTo(String s, long lastStringUpTo) {

        int asCount = 0;

        for (int i = 0; i < lastStringUpTo; i++)
            if (s.charAt(i) == 'a')
                asCount++;


        return asCount;
    }

    public static void main(String[] args) throws IOException {

        long result = repeatedString("aba", 10);
        System.out.println("resyult must me 7 " + result);
    }
}
