package splitarray;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, final int m) {
        int lo = 0;
        int hi = 0;

        for (int i = 0; i < nums.length; i++) {
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }


        return search(nums, m, lo, hi);
    }

    private int search(int[] nums, int m, int lo, int hi) {
        if (lo == hi) return lo; //make sure that you are converging the binary search results. Not all the time you can have a shortcut

        int mid = lo + (hi - lo) / 2;

        int splits = calcSplits(nums, mid);

        if (splits > m) {
            return search(nums, m, mid + 1, hi);
        } else {
            return search(nums, m, lo, mid);
        }
    }

    private int calcSplits(int[] nums, int mid) {
        int splits = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                splits++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return splits;
    }

}