classmaximumProfit {
    public int maximumProfit(int prices[]) {
        // code here
        int i,cost=0;
        int n = prices.length;
        for ( i = 1; i < n; i++) 
        { 
            if (prices[i] > prices[i - 1]) 
            { 
                cost += prices[i] - prices[i - 1]; 
                
            }
        }
        return cost;
    }
}
