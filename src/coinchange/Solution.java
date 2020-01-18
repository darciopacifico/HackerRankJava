package coinchange;

import java.util.Arrays;

public class Solution {
    private int FAILED = -1;

    private int minCount = Integer.MAX_VALUE;


    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        count(amount, coins.length - 1, coins, 0);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private void count(int amount, int index, int[] coins, int count) {
        if (index < 0) return;


        for (int countMoedas = amount / coins[index]; countMoedas >= 0; countMoedas--) {

            int amountMenosMoedas = amount - (countMoedas * coins[index]);
            int newCount = count + countMoedas;
            if (amountMenosMoedas > 0 && newCount + 1 < minCount)

                //testa a partir da moeda imediatamente menor
                count(amountMenosMoedas, index - 1, coins, newCount);
            else {
                if (amountMenosMoedas == 0)
                    minCount = Math.min(minCount, newCount);
                break;
            }
        }
    }


}