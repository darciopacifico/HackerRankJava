import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int pivotIndex = getPivotIndex(nums);

        if (pivotIndex != -1) {
            int index = getGreatestIndexToSwap(nums, pivotIndex);
            swap(pivotIndex, index, nums);
        }


        reverse(nums, pivotIndex);

        //System.out.println(pivotINDEX);

    }

    private int getGreatestIndexToSwap(int[] nums, int pivot) {

        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot])
                return i;
        }

        return 0;
    }

    private int getPivotIndex(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }

    public void swap(int x, int y, int[] nums) {
        if (x == y) return;
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void reverse(int[] nums, int from) {
        int temp;

        int l = from + 1;
        int r = nums.length - 1;

        while (l < r) {
            swap(l, r, nums);
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        //printNextPermutation(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        printNextPermutation(new int[]{3, 2, 1}, new int[]{1, 2, 3});
    }

    private static void printNextPermutation(int[] original, int[] ints) {
        int[] numsClone = original.clone();

        new NextPermutation().nextPermutation(numsClone);

        System.out.println("original :");
        System.out.println(Arrays.toString(original));
        System.out.println("next it must be :");
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(numsClone));
    }
}