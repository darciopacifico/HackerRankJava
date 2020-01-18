import java.io.IOException;

public class FlipBit {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {

        String str = Long.toString(n, 2);

        str = repeat("0", 32 - str.length()) + str;

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++)
            if (chars[i] == '1')
                chars[i] = '0';
            else
                chars[i] = '1';

        String flippedStr = new String(chars);

        long newLong = Long.parseLong(flippedStr, 2);

        return newLong;

    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(s.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {


        System.out.println("flipped 4294967295 : " + flippingBits(0));
        System.out.println("flipped 3492223820 : " + flippingBits(802743475));
        System.out.println("flipped 4259365872 : " + flippingBits(35601423));
    }
}
