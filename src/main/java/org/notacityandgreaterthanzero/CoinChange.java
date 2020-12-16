import java.util.*;
import java.util.stream.Collectors;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dpArray = new int[amount+1];
        Arrays.fill(dpArray, amount+1);

        dpArray[0] = 0;

        // outer loop iterates through dp array
        for(int i=0; i< dpArray.length; i++) {
            for(int j=0; j<coins.length; j++) {
                if(coins[j] <= i) {
                    dpArray[i] = Math.min(dpArray[i-coins[j]] + 1, dpArray[i]) ;
                }
            }
        }



        return dpArray[11] < 12 ? dpArray[11] : -1;

    }
    public static void main(String[] args) {
        CoinChange test = new CoinChange();
        test.coinChange(new int[]{1,2,5}, 11);
//        System.out.println(10 / 5);
//        System.out.println(10 / 2);
//        System.out.println(10 / 1);
//        System.out.println("2/1 =  " + 2/1);
//        System.out.println("3/2 = " + 3/2);


        int[] ints = new int[]{1,2,3,4,5};
        List<Integer> list1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        list1.add(6);
//        System.out.println(list1);

    }
}
