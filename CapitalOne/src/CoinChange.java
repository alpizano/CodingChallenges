import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<coins.length; i++) {
            map.put(coins[i],amount/coins[i] != 0 ? amount/coins[i] : null);
        }
        return 0;
    }
    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        test.coinChange(new int[]{1,2,5}, 4);
        System.out.println(10 / 5);
        System.out.println(10 / 2);
        System.out.println(10 / 1);

    }
}
