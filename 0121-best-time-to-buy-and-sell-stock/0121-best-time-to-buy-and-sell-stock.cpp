class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()==1) return 0;
        int min_price=prices[0];
        int maxprofit=0;

        for(int i=1; i<prices.size(); i++){
            if(prices[i]<min_price) min_price=prices[i];
            else if(prices[i]-min_price>maxprofit) maxprofit=prices[i]-min_price;
        }
        return maxprofit;
    }
};



// int max=0;
//         for(int i=0; i<prices.size()-1; i++){
//             int buy=*max_element(prices.begin()+i+1,prices.end());
//             int profit=buy-prices[i];
//             if(max<profit) max=profit;
//         }
//         return max;