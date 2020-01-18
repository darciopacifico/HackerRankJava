

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecialPalindrome {

    static class Point {
        public char key;
        public long count;

        public Point(char x, long y) {
            key = x;
            count = y;
        }
    }


    // Complete the substrCount function below.
    static long substrCount(int n, String s) {

        Point point = null;
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (point == null || point.key != s.charAt(i)) {
                point = new Point(s.charAt(i), 0);
                points.add(point);
            }
            point.count++;
        }


        long count = 0l;

        for (int i = 0; i < points.size(); i++) {

            Point pointC = points.get(i);

            count = count + (pointC.count * (pointC.count + 1) / 2);//ok

            if (i > 0 && i < points.size() - 1) {
                Point point1 = points.get(i - 1);
                Point point2 = points.get(i + 1);

                if (point1.key == point2.key && pointC.count == 1) {
                    count = count + Math.min(point1.count, point2.count);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File("/Users/darciopacifico/huge.txt"));

        String huge = null; //new String(IOUtils.readFully(inputStream, 327308, true));

        //printa("abcdefghgfedcba");
        printa("bvaoavb");

        //System.out.println("should be 10 " + substrCount(1, "abcba"));
        //System.out.println("should be 10 " + substrCount(1, "aaaa"));
        //System.out.println("should be 10 " + substrCount(1, huge));
    }

    private static void printa(String s) {
        System.out.println(s + " " + substrCount(1, s));
    }
}
