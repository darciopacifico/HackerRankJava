package inplaceunique;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(nums));

        Arrays.stream(nums).forEach(n -> System.out.print(n + ", "));
    }

    public int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int lastLegitPos = 0;

        int current = nums[0] + 1;

        for (int i = 0; i < nums.length; i++) {

            if (current != nums[i]) {
                nums[lastLegitPos] = nums[i];
                lastLegitPos++;
            }

            current = nums[i];

        }

        return lastLegitPos;

    }
}