class maximumProfitOne {
    public int maximumProfit(int prices[]) {
        // Code here
       if (prices.length == 0) 
        return 0; 
        int minPrice = Integer.MAX_VALUE; 
        int maxProfit = 0; 
        for (int i = 0; i < prices.length; i++) { 
            if (prices[i] < minPrice) { 
                minPrice = prices[i]; 
                
            } 
            else if (prices[i] - minPrice > maxProfit) { 
                maxProfit = prices[i] - minPrice; 
                
            } 
        } 
        return maxProfit;
    }
}
