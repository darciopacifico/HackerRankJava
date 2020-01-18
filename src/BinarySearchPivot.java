public class BinarySearchPivot {

    public int search(int[] nums, int target) {


        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int pivot = right + ((left - right) / 2);

            if (nums[pivot] == target)
                return pivot;
            else if (target > nums[pivot])
                left = pivot + 1;
            else if (target < nums[pivot])
                right = pivot - 1;

        }


        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearchPivot().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new BinarySearchPivot().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

    }
}
