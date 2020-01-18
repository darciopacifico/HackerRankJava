package trapwater;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


    public int trap(int[] heights) {

        int[] maxHeights = new int[heights.length];

        int left = 0, right = heights.length - 1;
        int area = 0;

        int lastMax = 0;
        while (left < right) {

            int thisMax = Math.min(heights[left], heights[right]);

            if (thisMax > lastMax) {
                lastMax = thisMax;
                for (int i = left; i <= right; i++) {
                    maxHeights[i] = lastMax;
                }
            }

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int mh = maxHeights[i];
            if (mh > h) {
                area = area + (mh - h);
            }
        }

        return area;
    }
}
