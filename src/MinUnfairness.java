import java.util.Arrays;

public class MinUnfairness {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int sK = Math.min(i + k - 1, arr.length - 1);

            min = Math.min(min, arr[sK] - arr[i]);

            if (i + k - 1 > arr.length - 2) {
                break;
            }

        }

        return min;

    }

    public static void main(String[] args) {

        // System.out.println("the min unfairness must be 3: " + maxMin(4, new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200}));

        System.out.println("the min unfairness must be 9: " + maxMin(2, new int[]{1, 10}));
    }
}
