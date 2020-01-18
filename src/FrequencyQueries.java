import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

    /*
    -  1x : Insert x in your data structure.
    -  2y : Delete one occurence of y from your data structure, if present.
    -  3z : Check if any integer is present whose frequency is exactly z. If yes, print 1 else 0.
    */

        Map<Integer, Integer> mapO = new HashMap<>();
        Map<Integer, Integer> mapF = new HashMap<>();

        List<Integer> resp = new LinkedList<>();

        for (List<Integer> q : queries) {

            mapO.putIfAbsent(q.get(0), 0);
            BiFunction<? super Integer, ? super Integer, ? extends Integer> sdsd = (x, y) -> x + y;

            Integer oldVal = mapO.get(q.get(0));
            //decrement this

            Integer newVal = mapO.compute(q.get(0), (x, y) -> x + y);
            //increment this

        }

        return resp;

    }

    public static void main(String[] args) {


    }
}
