import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountTriplets_old {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long ratiol) {
        double ratio = ratiol;

        List<Double> value = new ArrayList<>(arr.size());
        List<Double> count = new ArrayList<>(arr.size());

        Double lastV = null;
        for (Long lVal : arr) {
            Double cVal = lVal.doubleValue();

            if (cVal.equals(lastV)) {
                int lastIndex = count.size() - 1;
                count.set(lastIndex, count.get(lastIndex) + 1);
            } else {
                count.add(1d);
                value.add(cVal);
            }
            lastV = cVal;
        }

        Double countTriplet = 0d;

        //=C2*(C2-1)/2*(C2-2)/3
        if (ratio == 1) {

            for (int i = 0; i < value.size(); i++) {
                Double c = count.get(i);
                countTriplet = countTriplet + (c * (c - 1) / 2 * (c - 2) / 3);
            }

        } else {

            for (int i1 = 0; i1 < value.size() - 2; i1++) {

                int i2 = i1 + 1;
                int i3 = i1 + 2;

                while (i2 < value.size() - 1 && i3 < value.size()) {

                    if (i3 <= i2)
                        i3 = i2 + 1;

                    if (value.get(i1) * ratio == value.get(i2)) {

                        //value 1 and 2 OK
                        if (value.get(i2) * ratio == value.get(i3)) {
                            double c1 = count.get(i1);
                            double c2 = count.get(i2);
                            double c3 = count.get(i3);
                            countTriplet = countTriplet + (c1 * (c2) * (c3));
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i2++;
                    }
                }
            }
        }

        return countTriplet.longValue();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("" + countTriplets(Arrays.asList(1l, 2l, 4l, 10l, 20l, 40l, 100l, 200l, 400l), 2));



/*
        System.out.println("" + countTriplets(Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l), 3));
        System.out.println("" + countTriplets(Arrays.asList(1l, 5l, 5l, 25l, 125l), 5));
        System.out.println("" + countTriplets(Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l), 3));
        System.out.println("" + countTriplets(Arrays.asList(9l, 9l, 9l, 9l, 9l, 9l, 9l), 1));
        System.out.println("" + countTriplets(Arrays.asList(3l, 3l, 3l, 3l, 3l, 3l, 3l), 1));
*/

    }
}
