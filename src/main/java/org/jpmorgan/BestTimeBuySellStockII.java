//public class BestTimeBuySellStockII {
//    public int maxProfit(int[] prices) {
//        int sum =0;
//        int answer = helper(prices, 0, sum);
//        return answer;
//    }
//
//    public int helper(int[] prices, int start, int sum) {
//        for(int i=0; i<prices.length; i++ ){
//            for(int j=i+1; j<prices.length; j++) {
//                int tmp = prices[j] - prices[i];
//
//                if(tmp > maxProfit) {
//                    sum = sum + helper(prices, i+1);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] input = new int[]{7, 1, 5, 3, 6, 4};
//
//        BestTimeBuySellStockII test = new BestTimeBuySellStockII();
//
//        System.out.println(test.maxProfit(input));
//    }
//}
