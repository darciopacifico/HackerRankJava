package invervalmerge;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

        System.out.println(
                Arrays.stream(
                        new Solution().merge(new int[][]{
                                new int[]{1, 3},
                                new int[]{2, 6},
                                new int[]{8, 10},
                                new int[]{15, 18}

                        }))
                        .map(arr -> "[" + arr[0] + "," + arr[1] + "]")
                        .collect(Collectors.joining(" "))
        );
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0)
            return new int[0][2];

        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int[][] resp = new int[intervals.length][2];

        int start = intervals[0][0];
        int end = intervals[0][1];

        int index = 0;

        for (int i = 1; i < intervals.length; i++) {


            if (end >= intervals[i][0]) {
                // overlap
                end = Math.max(end, intervals[i][1]);
            } else {
                resp[index++] = new int[]{start, end};
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        resp[index++] = new int[]{start, end};

        return Arrays.copyOf(resp, index);
    }


}