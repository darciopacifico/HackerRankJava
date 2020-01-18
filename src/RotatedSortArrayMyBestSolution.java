public class RotatedSortArrayMyBestSolution {

    public int search(int[] nums, int target) {


        return search(nums, 0, nums.length - 1, target);

    }

    private int search(int[] a, int start, int end, int target) {
        return 0;

    }


    public static void main(String[] args) {
        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{1, 3}, 3));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{}, 4));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{4, 5, 6, 0, 1, 2, 3}, 4));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{0, 1, 2, 3, 4, 5, 6}, 0));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{6, 0, 1, 2, 3, 4, 5}, 1));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{5, 6, 0, 1, 2, 3, 4}, 2));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{3, 4, 5, 6, 0, 1, 2}, 4));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{2, 3, 4, 5, 6, 0, 1}, 5));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{1, 2, 3, 4, 5, 6, 0}, 6));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{3, 4, 5, 6, 0, 1, 2}, 4));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{3, 4, 5, 0, 1, 2}, 3));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{3, 4, 0, 1, 2}, 2));

        System.out.println("" + new RotatedSortArrayMyBestSolution().search(new int[]{3, 0, 1, 2}, 2));
    }
}
