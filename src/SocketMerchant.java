public class SocketMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        boolean[] sockType = new boolean[1000];

        int pairs = 0;

        for (int i = 0; i < n; i++) {
            if (sockType[ar[i]])
                pairs++;

            sockType[ar[i]] = !sockType[ar[i]];
        }


        return pairs;

    }

    public static void main(String[] args) {

        System.out.println(sockMerchant(10, new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3, 1}));

        System.out.println(sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }
}
