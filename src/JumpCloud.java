import java.io.IOException;
import java.util.Scanner;

public class JumpCloud {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        return jumpingOnClouds(c, 0, 0);
    }


    static int jumpingOnClouds(int[] c, int position, int jumpCount) {
        int lastCloud = c.length - 1;

        if (position == lastCloud) return jumpCount;

        int nextPosition;

        if (position + 2 <= lastCloud && c[position + 2] == 0) {
            nextPosition = position + 2;
        } else {
            nextPosition = position + 1;
        }
        return jumpingOnClouds(c, nextPosition, ++jumpCount);

    }


    public static void main(String[] args) throws IOException {

        int count = jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});


        System.out.println("must be 4. was " + count);

    }
}


