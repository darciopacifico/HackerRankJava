import java.util.ArrayList;
import java.util.List;

/*
[1,2,3]
[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]
*/
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList();

        permutations(0, nums, permutations);


        return permutations;
    }

    private void permutations(int start, int[] nums, List<List<Integer>> permutations) {

        for (int i = start; i < nums.length; i++) {

            swap(start, i, nums);

            permutations(start + 1, nums, permutations);

            swap(i, start, nums);

        }
        if (start == nums.length - 1)
            registerPermutation(nums, permutations);

    }

    private void registerPermutation(int[] nums, List<List<Integer>> permutations) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : nums) {
            intList.add(i);
        }
        permutations.add(intList);
    }

    public void swap(int x, int y, int[] nums) {
        if (x == y) return;
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {

        List<List<Integer>> res = new Permutations().permute(new int[]{1, 2, 3});

        res.forEach(System.out::println);

    }
}