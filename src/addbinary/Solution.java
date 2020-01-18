package addbinary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String addBinary(String a, String b) {

        List<String> listA = reverse(a);
        List<String> listB = reverse(b);


        return "";

    }

    private List<String> reverse(String a) {
        List<String> listA = Arrays.asList(a);
        Collections.reverse(listA);
        return listA;
    }
}
