class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }

        return maxProfit;
    }
}
