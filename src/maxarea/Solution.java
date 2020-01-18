package maxarea;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,23,45,2,5,45,8,2,3}));
    }

    public int maxArea(int[] height) {

        int biggestArea = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int dist = j - i;

                int alt = Math.min(height[i], height[j]);

                biggestArea = Math.max(biggestArea, dist * alt);

            }

        }

        return biggestArea;
    }

}
