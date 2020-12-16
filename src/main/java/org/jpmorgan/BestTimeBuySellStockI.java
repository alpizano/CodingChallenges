public class BestTimeBuySellStockI {
    public int maxProfit(int[] prices) {
        int maxProfit =0;

        for(int i=0; i<prices.length; i++) {
            for(int j=i+1; j<prices.length; j++) {
                // first profit = -6
                int tmp = prices[j] - prices[i];
                if(tmp > maxProfit) {
                    maxProfit = tmp;
                }

            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7,6,5,4,3,2};

        BestTimeBuySellStockI test = new BestTimeBuySellStockI();

        System.out.println( test.maxProfit(array));
    }
}
