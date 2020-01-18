import java.io.IOException;

public class CountInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {

        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] helper, int start, int incEnd) {
        long count = 0;

        if (start != incEnd) {
            int mid = (start + incEnd) / 2;
            count += mergeSort(arr, helper, start, mid);
            count += mergeSort(arr, helper, mid + 1, incEnd);
            count += merge(arr, helper, start, mid, incEnd);
        }

        return count;
    }

    private static long merge(int[] arr, int[] helper, int start, int mid, int end) {

        for (int i = start; i <= end; i++) { // notice "i" goes from "start" to "end", not "0" to "array.length"
            helper[i] = arr[i];
        }

        int curr = start;
        int left = start;
        int right = mid + 1;

        long swaps = 0l;

        while (left <= mid && right <= end) {
            if (helper[left] <= helper[right]) {
                arr[curr++] = helper[left++];
            } else {
                swaps += mid + 1 - left;
                arr[curr++] = helper[right++];
            }
        }

        /* Copy remaining elements of left half. Right half elements are already in proper place */
        while (left <= mid) {
            arr[curr++] = helper[left++];
        }

        return swaps;

    }

    public static void main(String[] args) throws IOException {

        System.out.println("0: " + countInversions(new int[]{1, 1, 1, 2, 2}));

        System.out.println("4: " + countInversions(new int[]{2, 1, 3, 1, 2}));


    }
}
