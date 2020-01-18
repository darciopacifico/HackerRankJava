import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    public static void main(String[] args) throws IOException {
        System.out.println("" + countTriplets(getLongs(100000, 1237l), 1));
        System.out.println("" + countTriplets(Arrays.asList(1l, 5l, 5l, 25l, 125l), 5));
        System.out.println("" + countTriplets(Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l), 3));

        System.out.println("" + countTriplets(Arrays.asList(3l, 3l, 3l, 3l, 3l, 3l, 3l), 1));
        System.out.println("" + countTriplets(Arrays.asList(9l, 9l, 9l, 9l, 9l, 9l, 9l), 1));
    }

    private static long countTriplets(List<Long> longs, int r) {

        Map<Long, Long> left = new HashMap<>(), right = new HashMap<>();

        for (int j = 0; j < longs.size(); j++) {
            Long valor = longs.get(j);
            right.putIfAbsent(valor, 0L);
            right.compute(valor, (k, v) -> v + 1);
        }

        long count = 0L;
        for (int j = 0; j < longs.size(); j++) {
            Long valor = longs.get(j);

            right.compute(valor, (k, v) -> v - 1);

            if (valor % r == 0) {

                Long leftVal = left.getOrDefault(valor / r, 0L);
                Long rigthVal = right.getOrDefault(valor * r, 0L);

                count += leftVal * rigthVal;
            }

            left.putIfAbsent(valor, 0L);
            left.compute(valor, (k, v) -> v + 1);
        }

        return count;
    }

    private static List<Long> getLongs(int size, long value) {
        Long[] longs = new Long[size];

        for (int i = 0; i < longs.length; i++)
            longs[i] = value;

        return Arrays.asList(longs);
    }
}
