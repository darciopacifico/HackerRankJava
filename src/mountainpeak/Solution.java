package mountainpeak;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0, -1, -2, -3, -4, -5}));
    }

    public int peakIndexInMountainArray(int[] A) {

        return peakIndexInMountainArray(A, 0, A.length - 1);

    }


    private int peakIndexInMountainArray(int[] A, int start, int end) {

        int mid = start + ((end - start) / 2);

        if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {

            return mid;

        } else if (A[mid] < A[mid + 1]) {

            return peakIndexInMountainArray(A, mid + 1, end);

        }

        return peakIndexInMountainArray(A, start, mid - 1);


    }

}