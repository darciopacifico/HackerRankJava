package alltriplets;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        Arrays.sort(nums);

        Set<List<Integer>> triplets = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int t = 0 - (nums[i] + nums[j]);

                int k = Arrays.binarySearch(nums, i + 1, j, t);
                if (k >= 0) {

                    List<Integer> triplet = new ArrayList<>(3);
                    triplet.add(nums[i]);
                    triplet.add(nums[k]);
                    triplet.add(nums[j]);
                    triplets.add(triplet);
                }


            }
        }


        return triplets.stream().collect(Collectors.toList());

    }
}
