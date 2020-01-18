package groupanagram;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Set<Integer>, List<String>> mapAnagrams = new HashMap<>();

        for (String str : strs) {

            Set<Integer> key = str.chars().boxed().collect(Collectors.toSet());

            if (!mapAnagrams.containsKey(key)) {
                mapAnagrams.put(key, new LinkedList<>());
            }

            mapAnagrams.get(key).add(str);
        }

        return new ArrayList<>(mapAnagrams.values());
    }
}