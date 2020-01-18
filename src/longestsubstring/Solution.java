package longestsubstring;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("a"));
        System.out.println(new Solution().lengthOfLongestSubstring("aaaaaaaaaaaa"));
        System.out.println(new Solution().lengthOfLongestSubstring("pewwehjklxyz"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }

    public int lengthOfLongestSubstring(String s) {

        int[] lastFound = new int[200];
        Arrays.fill(lastFound, -1);

        int biggest = 0;

        int start = -1;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            start = Math.max(start, lastFound[c]); // start must be moved

            lastFound[c] = i; // mark the last seen, start  still the same

            biggest = Math.max(biggest, i - start);

        }

        return biggest;
    }
}