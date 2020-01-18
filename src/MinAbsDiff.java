import java.util.stream.IntStream;

public class MinAbsDiff {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {


        int[] arraySortedAbs = IntStream.of(arr).sorted().toArray();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arraySortedAbs.length - 1; i++) {


            int abs = Math.abs(arraySortedAbs[i] - arraySortedAbs[i + 1]);
            if (abs < minDiff) {
                minDiff = abs;
            }
        }


        return minDiff;

    }

    public static void main(String[] args) {

        System.out.println("min abs diff must be 1 :" + minimumAbsoluteDifference(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));

    }
}
