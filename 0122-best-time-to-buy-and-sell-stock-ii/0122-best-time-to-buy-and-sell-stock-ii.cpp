class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()==1) return 0;
        // if(prices.size()==2){
        //     if(prices[0]<prices[1]) return prices[1]-prices[0];
        //     else return 0;
        // }
        int day=0;
        int profit=0;
        while(day<prices.size()-1){
            if(prices[day]<prices[day+1]) 
            profit+=prices[day+1]-prices[day];
            day++;
        }
        return profit;
    }
};