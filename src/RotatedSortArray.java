public class RotatedSortArray {

    public int search(int[] nums, int target) {

        if (nums.length == 0) return -1;
        int start = findStart(nums);

        if (start == 0) {
            return search(nums, 0, nums.length - 1, target);
        } else if (target < nums[0])
            return search(nums, start, nums.length - 1, target);
        else if (target > nums[0])
            return search(nums, 0, start, target);
        else
            return 0;

    }

    private int search(int[] a, int start, int end, int target) {

        if (start == end) {
            return a[start] == target ? start : -1;
        }

        int mid = start + ((end - start) / 2);

        if (target > a[mid]) {
            return search(a, mid + 1, end, target);
        } else if (target < a[mid]) {
            return search(a, start, mid, target);
        } else {
            return mid;
        }

    }

    private int findStart(int[] nums) {
        return findStart(nums, 0, nums.length - 1);
    }

    private int findStart(int[] a, int start, int end) {


        if (a[start] <= a[end])
            return start;

        int mid = start + ((end - start) / 2);

        if (a[mid] > a[end]) {
            return findStart(a, mid + 1, end);
        } else if (a[mid] < a[start]) {
            return findStart(a, start + 1, mid);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        System.out.println("" + new RotatedSortArray().search(new int[]{1, 3}, 3));

        System.out.println("" + new RotatedSortArray().search(new int[]{}, 4));

        System.out.println("" + new RotatedSortArray().search(new int[]{4, 5, 6, 0, 1, 2, 3}, 4));

        System.out.println("" + new RotatedSortArray().search(new int[]{0, 1, 2, 3, 4, 5, 6}, 0));

        System.out.println("" + new RotatedSortArray().search(new int[]{6, 0, 1, 2, 3, 4, 5}, 1));

        System.out.println("" + new RotatedSortArray().search(new int[]{5, 6, 0, 1, 2, 3, 4}, 2));

        System.out.println("" + new RotatedSortArray().search(new int[]{3, 4, 5, 6, 0, 1, 2}, 4));

        System.out.println("" + new RotatedSortArray().search(new int[]{2, 3, 4, 5, 6, 0, 1}, 5));

        System.out.println("" + new RotatedSortArray().search(new int[]{1, 2, 3, 4, 5, 6, 0}, 6));

        System.out.println("" + new RotatedSortArray().search(new int[]{3, 4, 5, 6, 0, 1, 2}, 4));

        System.out.println("" + new RotatedSortArray().search(new int[]{3, 4, 5, 0, 1, 2}, 3));

        System.out.println("" + new RotatedSortArray().search(new int[]{3, 4, 0, 1, 2}, 2));

        System.out.println("" + new RotatedSortArray().search(new int[]{3, 0, 1, 2}, 2));
    }
}
