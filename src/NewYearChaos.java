public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        System.out.println(minBribes(q));
    }

    static Object minBribes(int[] q) {

        int count = 0;

        for (int i = q.length - 1; i >= 0; i--) {

            if (q[i] - (i + 1) > 2) {
                return "Too chaotic";
            }


            int max = Math.max(0, q[i] - 2);
            for (int j = max; j < i; j++) {

                if (q[j] > q[i]) {

                    System.out.println(q[j] + " bribed " + q[i]);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {    //              1  2  3  4  5
        /*System.out.println("3           " + minBribes(new int[]{2, 1, 5, 3, 4}));
        System.out.println("Too chaotic " + minBribes(new int[]{2, 5, 1, 3, 4}));
        System.out.println("Too chaotic " + minBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4}));
*/
        //                                                      1  2  3  4  5  6  7  8
        System.out.println("7           " + minBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}));
        //                                                      0  0  2 -1  2  2 -1 -4

    }
}
