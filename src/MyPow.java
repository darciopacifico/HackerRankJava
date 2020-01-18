public class MyPow {

    public static void main(String[] args) {

        //System.out.println(new MyPow().myPow(3.2, 9));
        //System.out.println(new MyPow().myPow(2, -2));
        System.out.println(new MyPow().myPow(0.00001, 2147483647));


    }

    public enum Colors {
        RED, GREEN, BLUE
    }

    public double myPow(double x, int n) {
        double res = 1;


        if (n >= 0) {
            for (int i = 0; i < n; i++)
                res = res * x;


        } else {
            for (int i = n; i < 0; i++)
                res = res / x;
        }


        return res;
    }
}
