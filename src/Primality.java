public class Primality {

    // Complete the primality function below.
    static String primality(long n) {
        if (n == 2) {
            return "Prime";
        } // 1 is not prime, even numbers > 2 are not prime
        else if (n == 1 || (n & 1) == 0) {
            return "Not prime";
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {

            if (n % i == 0d) {
                return "Not prime";
            }

        }

        // 2 3 5 8

        return "Prime";
    }


    public static void main(String[] args) {
        System.out.println("Prime: " + primality(3));
        System.out.println("Not Prime: " + primality(4));
        System.out.println("Not Prime: " + primality(10));
        System.out.println("Prime: " + primality(37));
        System.out.println("Prime: " + primality(1000000009));

    }
}

