import java.util.Arrays;

public class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        int[] dpArray = new int[amount+1];
        Arrays.fill(dpArray, amount +1);

        dpArray[0] = 0;

        for(int i=0; i<dpArray.length; i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j] <= i) {
                    dpArray[i] = Math.min(dpArray[i - coins[j]] + 1, dpArray[i]);
                }
            }
        }
        return dpArray[dpArray.length-1] < amount+1 ? dpArray[dpArray.length-1] : -1;

    }
    public static void main(String[] args) {

    }
}
