public class RotatedArrayBestSolution {

    public int search(int[] nums, int target) {
        int left, right;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid;

            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return (mid);
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }

        return (-1);
    }


}
