package amazoninterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /*
input1: [1,5,7]
input2: [2,4,9,10]
output: [1,2,4,5,7,9,10]
*/
    public static void main(String[] args) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        listA.add(1);
        listA.add(5);
        listA.add(7);

        listB.add(2);
        listB.add(4);
        listB.add(9);
        listB.add(10);

        System.out.println(new Solution().mergeLists(listA, listB));
    }

    public List<Integer> mergeLists(List<Integer> listA, List<Integer> listB) {
        //null checks

        List<Integer> mergeList = new LinkedList<Integer>();
        mergeLists(listA, 0, listB, 0, mergeList);
        return mergeList;
    }

    private void mergeLists(List<Integer> listA, Integer indexA, List<Integer> listB, Integer indexB, List<Integer> mergeResult) {

        if (listA.size() > indexA && listB.size() > indexB) {

            if (listA.get(indexA) < listB.get(indexB)) {

                mergeResult.add(listA.get(indexA));
                mergeLists(listA, ++indexA, listB, indexB, mergeResult);

            } else {

                mergeResult.add(listB.get(indexB));
                mergeLists(listA, indexA, listB, ++indexB, mergeResult);
            }

        } else if (listA.size() > indexA) {
            mergeResult.addAll(listA.subList(indexA, listA.size()));
        } else if (listB.size() > indexB) {
            mergeResult.addAll(listB.subList(indexB, listB.size()));
        }

    }

}
