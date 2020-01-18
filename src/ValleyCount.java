import java.io.IOException;
import java.util.Scanner;

public class ValleyCount {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int count = 0;
        int level = 0;
        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == 'U') {
                level++;
            } else {

                if (level == 0) {
                    count++;
                }


                level--;
            }


        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println(countingValleys(8, "UDDDUDUU"));


    }
}