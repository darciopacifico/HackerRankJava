import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MinimumSwaps {

    public static final int ORI = 0;
    public static final int VAL = 1;

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {


        int[][] pairArr = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            pairArr[i][ORI] = i;
            pairArr[i][VAL] = arr[i];
        }

        //System.out.println("antes");
        //printArray(pairArr);

        Arrays.sort(pairArr, Comparator.comparingInt(a -> a[VAL]));

        //System.out.println("depois");
        //printArray(pairArr);

        Set<Integer> visited = new HashSet<>();

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (!visited.contains(i) && pairArr[i][ORI] != i) {

                int j = pairArr[i][ORI];

                while (!visited.contains(j)) {
                    visited.add(j);
                    j = pairArr[j][ORI];
                    count++;
                }
                count--;
            }
        }

        return count;
    }

    private static void printArray(int[][] pairArr) {
        Arrays.stream(pairArr).forEach(a -> System.out.println(" ori = " + a[ORI] + " val = " + a[VAL]));
    }

    public static void main(String[] args) {

        System.out.println("expects 5 " + minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6}));

    }

}