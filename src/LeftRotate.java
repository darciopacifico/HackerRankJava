import java.io.IOException;
import java.util.Arrays;

public class LeftRotate {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int dd) {

        int[] arrDest = new int[a.length];

        for (int i = 0; i < arrDest.length; i++) {

            int d = i - dd;

            if (d < 0) {
                d = arrDest.length + d;
            }

            arrDest[d] = a[i];
        }

        return arrDest;
    }

    public static void main(String[] args) throws IOException {
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1);
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5);
        print(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6);
    }

    private static void print(int[] a, int d) {
        int[] x = rotLeft(a, d);
        System.out.println("moving " + d);
        Arrays.stream(x).forEach(System.out::print);
        System.out.println();
        System.out.println();
    }
}
