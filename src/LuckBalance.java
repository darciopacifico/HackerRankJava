import java.io.IOException;
import java.util.Arrays;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {

        Arrays.sort(contests, (o1, o2) -> {

            int diff = o2[1] - o1[1];

            if (diff == 0) {
                return o2[0] - o1[0];
            } else {
                return diff;
            }

        });

        int lBalance = 0;
        for (int i = 0; i < contests.length; i++) {

            if (contests[i][1] == 0) {
                lBalance = lBalance + contests[i][0];
            } else {

                if (k > 0) {
                    lBalance = lBalance + contests[i][0];
                    k--;
                } else {

                    lBalance = lBalance - contests[i][0];
                }
            }
        }

        return lBalance;
    }

    public static void main(String[] args) throws IOException {
/*
        System.out.println("It must be 29 " + luckBalance(3, new int[][]{
                new int[]{5, 1},
                new int[]{2, 1},
                new int[]{1, 1},
                new int[]{8, 1},
                new int[]{10, 0},
                new int[]{5, 0},
        }));

        System.out.println("It must be 31 " + luckBalance(3, new int[][]{
                new int[]{5, 1},
                new int[]{6, 1},
                new int[]{2, 1},
                new int[]{1, 1},
                new int[]{8, 1},
                new int[]{10, 0},
                new int[]{5, 0},
        }));

        System.out.println("It must be 5 " + luckBalance(0, new int[][]{
                new int[]{5, 0}
        }));

        System.out.println("It must be 5 " + luckBalance(1, new int[][]{
                new int[]{5, 1}
        }));

        System.out.println("It must be -5 " + luckBalance(0, new int[][]{
                new int[]{5, 1}
        }));*/

        System.out.println("It must be 10069 " + luckBalance(58, new int[][]{

                new int[]{105, 0},
                new int[]{103, 0},
                new int[]{106, 1},
                new int[]{106, 1},
                new int[]{103, 0},
                new int[]{103, 1},
                new int[]{105, 1},
                new int[]{106, 1},
                new int[]{105, 0},
                new int[]{104, 0},
                new int[]{103, 0},
                new int[]{102, 0},
                new int[]{104, 0},
                new int[]{105, 0},
                new int[]{104, 0},
                new int[]{102, 1},
                new int[]{104, 0},
                new int[]{106, 1},
                new int[]{104, 1},
                new int[]{101, 1},
                new int[]{105, 0},
                new int[]{103, 0},
                new int[]{104, 0},
                new int[]{106, 0},
                new int[]{102, 1},
                new int[]{103, 0},
                new int[]{102, 0},
                new int[]{103, 1},
                new int[]{106, 0},
                new int[]{104, 1},
                new int[]{101, 1},
                new int[]{101, 1},
                new int[]{106, 0},
                new int[]{103, 1},
                new int[]{103, 0},
                new int[]{104, 1},
                new int[]{101, 0},
                new int[]{105, 1},
                new int[]{105, 0},
                new int[]{104, 1},
                new int[]{105, 0},
                new int[]{106, 0},
                new int[]{104, 0},
                new int[]{105, 0},
                new int[]{101, 1},
                new int[]{106, 1},
                new int[]{105, 0},
                new int[]{103, 0},
                new int[]{104, 1},
                new int[]{101, 1},
                new int[]{106, 1},
                new int[]{104, 0},
                new int[]{106, 1},
                new int[]{105, 0},
                new int[]{103, 1},
                new int[]{101, 0},
                new int[]{103, 0},
                new int[]{101, 0},
                new int[]{105, 1},
                new int[]{104, 1},
                new int[]{104, 1},
                new int[]{105, 1},
                new int[]{105, 1},
                new int[]{103, 0},
                new int[]{101, 0},
                new int[]{104, 1},
                new int[]{106, 1},
                new int[]{105, 1},
                new int[]{105, 0},
                new int[]{106, 1},
                new int[]{104, 1},
                new int[]{105, 1},
                new int[]{103, 1},
                new int[]{102, 1},
                new int[]{106, 0},
                new int[]{101, 0},
                new int[]{105, 1},
                new int[]{104, 1},
                new int[]{103, 1},
                new int[]{106, 1},
                new int[]{101, 0},
                new int[]{106, 1},
                new int[]{103, 0},
                new int[]{106, 1},
                new int[]{102, 1},
                new int[]{103, 0},
                new int[]{101, 1},
                new int[]{102, 1},
                new int[]{101, 1},
                new int[]{104, 0},
                new int[]{106, 0},
                new int[]{102, 0},
                new int[]{104, 0},
                new int[]{105, 0},
                new int[]{105, 0},
                new int[]{102, 1},
                new int[]{103, 1}

        }));

    }
}

/*

3

8 1  +8
5 1  +5
2 1  +2
1 1  -1
10 0 +10
5 0  +5

8+5+2-1+10+5*/
