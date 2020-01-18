package trapwaterii;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().trapRainWater(new int[][]{
                new int[]{1, 4, 3, 1, 3, 2},
                new int[]{3, 2, 1, 3, 2, 4},
                new int[]{2, 3, 3, 2, 3, 1}
        }));
    }

    public int trapRainWater(int[][] heightMap) {

        int height = heightMap.length;
        int width = height == 0 ? 0 : heightMap[0].length;


        for (int i = 0; i < heightMap.length; i++) {

            int[] widthMap = heightMap[i];

            for (int j = 0; j < width; j++) {


            }

        }

        return 0;

    }
}
