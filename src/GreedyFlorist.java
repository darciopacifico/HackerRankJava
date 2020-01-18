import java.io.IOException;
import java.util.Arrays;

public class GreedyFlorist {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {

        Arrays.sort(c);

        int priceSum = 0;

        for (int i = c.length - 1; i >= 0; i--) {
            int timesPrice = (c.length - 1 - i) / k;
            priceSum = priceSum + (timesPrice + 1) * c[i];

        }

        return priceSum;

    }

    public static void main(String[] args) throws IOException {

        System.out.println("it must be 29: " + getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));

        /*

         9 + 7 + 5  +6 + 2

         */
    }
}
