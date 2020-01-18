import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MaxCircleUnionFind {

    // Complete the maxCircle function below.
    static int[] maxCircle(int[][] queries) {

        MyMap el = new MyMap();
        MyMap sz = new MyMap(1);

        int max = 0;

        int[] resp = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            a = root(el, a);
            b = root(el, b);

            if (sz.get(a) > sz.get(b))
                max = joinAndGetMax(el, sz, max, a, b);
            else
                max = joinAndGetMax(el, sz, max, b, a);


            resp[i] = max;
        }

        return resp;

    }

    private static int joinAndGetMax(MyMap el, MyMap sz, int max, int a, int b) {
        if (a != b) {
            el.put(b, a);
            sz.increment(a, sz.get(b));
            max = Math.max(max, sz.get(a));
        }
        return max;
    }

    private static int root(Map<Integer, Integer> el, int e) {
        while (!el.get(e).equals(e)) {
            el.put(e, el.get(el.get(e)));
            e = el.get(e);
        }

        return e;
    }

    private static class MyMap extends HashMap<Integer, Integer> {
        private Integer defaultV;

        public MyMap(Integer defaultV) {
            this.defaultV = defaultV;
        }

        public MyMap() {
        }

        @Override
        public Integer get(Object key) {

            if (!super.containsKey(key))
                return defaultV == null ? (Integer) key : defaultV;

            return super.get(key);
        }

        public void increment(Integer k, Integer v) {

            Integer cur = super.getOrDefault(k, 1);

            int some = cur + v;

            super.put(k, some);
        }
    }


    public static void main(String[] args) throws IOException {

        printResp(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4},
                new int[]{1, 3},
                new int[]{5, 7},
                new int[]{5, 6},
                new int[]{7, 4}
        }, new int[]{2, 2, 4, 4, 4, 7});

        printResp(new int[][]{
                new int[]{1000000000, 23},
                new int[]{11, 3778},
                new int[]{7, 47},
                new int[]{11, 1000000000}
        }, new int[]{2, 2, 2, 4});


        printResp(new int[][]{
                new int[]{6, 4},
                new int[]{5, 9},
                new int[]{8, 5},
                new int[]{4, 1},
                new int[]{1, 5},
                new int[]{7, 2},
                new int[]{4, 2},
                new int[]{7, 6}
        }, new int[]{2, 2, 3, 3, 6, 6, 8, 8});


    }

    private static void printResp(int[][] queries, int[] ints) {
        System.out.println();
        int[] res = maxCircle(queries);
        for (int i = 0; i < res.length; i++) {
            System.out.println("should be " + ints[i] + " - " + res[i]);
        }
    }


}
