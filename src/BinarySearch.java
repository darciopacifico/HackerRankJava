public class BinarySearch {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] arr, int target, int start, int end) {
        if (start == end)
            return arr[start] == target ? start : -1;


        int mid = start + ((end - start) / 2);

        if (target == arr[mid]) {
            return mid;

        } else if (target > arr[mid])
            return search(arr, target, mid + 1, end);
        else
            return search(arr, target, start, mid);

    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));

    }
}
