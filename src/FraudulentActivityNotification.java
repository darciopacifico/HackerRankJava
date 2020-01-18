import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FraudulentActivityNotification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] exps, int d) {

        PriorityQueue<Integer> majors = new PriorityQueue<>();
        PriorityQueue<Integer> minors = new PriorityQueue<>(Comparator.reverseOrder());

        int count = 0;

        for (int i = 0; i < exps.length; i++) {
            int exp = exps[i];

            if (i >= d) {
                balance(majors, minors, d);
                double m = median(majors, minors);
                if (exp >= (m * 2))
                    count++;
            }

            feedPQs(majors, minors, exp);
            if (i >= d) {
                removeLast(exps, d, majors, minors, i);
            }


        }

        return count;
    }

    private static double median(PriorityQueue<Integer> majors, PriorityQueue<Integer> minors) {

        if (majors.size() == minors.size())
            return (majors.peek() + minors.peek()) / 2.0;
        else if (majors.size() == minors.size() + 1)
            return majors.peek();
        else
            throw new IllegalStateException("UNBALANCED PQs!");

    }

    private static void balance(PriorityQueue<Integer> majors, PriorityQueue<Integer> minors, int d) {

        if ((majors.size() + minors.size()) != d) {
            throw new IllegalStateException("inconsistent PQ sizes");
        }

        while (minors.size() > majors.size() || majors.size() > minors.size() + 1) {

            if (minors.size() > majors.size()) {
                majors.add(minors.poll());

            } else if (majors.size() > minors.size() + 1) {
                minors.add(majors.poll());
            }
        }


    }

    private static void removeLast(int[] exps, int d, PriorityQueue<Integer> majors, PriorityQueue<Integer> minors, int i) {

        if (!minors.isEmpty() && exps[i - d] <= minors.peek())
            minors.remove(exps[i - d]);
        else if (!majors.isEmpty() && exps[i - d] >= majors.peek())
            majors.remove(exps[i - d]);
        else
            throw new IllegalStateException("loose control");

        if ((minors.size() + majors.size()) != d) {
            throw new IllegalStateException("Inconsistent PQ after removal");
        }

    }

    private static void feedPQs(PriorityQueue<Integer> majors, PriorityQueue<Integer> minors, int exp) {
        if (majors.isEmpty() && minors.isEmpty())
            majors.add(exp);

        else if (!majors.isEmpty())
            if (exp > majors.peek())
                majors.add(exp);
            else
                minors.add(exp);

        else if (exp < minors.peek())
            minors.add(exp);
        else
            majors.add(exp);
    }

    public static void main(String[] args) throws IOException {

        FileInputStream is = new FileInputStream("/Users/darciopacifico/Documents/HackerhankJava/src/case5.txt");

        InputStreamReader i = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(i);
        String line = br.readLine();

        String[] numbers = line.split(" ");

        int[] ints = Arrays.stream(numbers).mapToInt(Integer::new).toArray();

        System.out.println("must be 926: " + activityNotifications(ints, 40001));

        System.out.println("");
/*
        System.out.println("must be 1: " + activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));

        System.out.println("must be 2: " + activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));

        System.out.println("must be 0: " + activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));*/
    }//                                                                    0  1  2  3  4  5  6  7  8
}
