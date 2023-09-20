class Solution {
public:
    int hIndex(vector<int>& citations) {
        int num=0;
        for(int i=citations.size(); i>0; i--){
            for(auto c: citations){
                if(i<=c) num++;
            }
            if(i<=num && i<=citations.size()) return i;
            num=0;
        }
        return 0;
    }
};



// the given researcher has published at least h papers  c.size()=> paper_num
// have each been cited at least h times.    
// ex1) paper_num = 5
// 0 =>5
// 1 =>4 
// 2 =>3
// 3 =>3 * && 3<=5
// 4 =>2
// 5 =>2
// 6 =>1 
// 7 =>0 


// ex2) parper_num = 3
// 0 =>3
// 1 =>3 * && 1<=3
// 2 =>1
// 3 =>1
// No Citations:
// Input: [0, 0, 0, 0, 0]
// 0=>0 * && 0<=5  return 0
// 1=>0
// 2=>0
// 3=>0
// 4=>0
// 5=>0 
// Expected Output: 0
// Explanation: The researcher has no papers with any citations.
// Ascending Citations:

// Input: [1, 2, 3, 4, 5]
// 0=>0 * && 0<=5
// 1=>0
// 2=>0
// 3=>3 * && 3<=5 ok return 3
// 4=>2
// 5=>1 
// Expected Output: 3
// Explanation: The researcher has 3 papers with at least 3 citations each.
// Descending Citations:

// Input: [5, 4, 3, 2, 1]
// 0=>0 * && 0<=5
// 1=>0
// 2=>0
// 3=>3 * && 3<=5
// 4=>2
// 5=>1
// Expected Output: 3
// Explanation: Just like the previous test case but in descending order. It helps ensure the solution isn't relying on the order of elements.
// Same Citations:

// Input: [2, 2, 2, 2, 2]
// 0=>0 
// 1=>0
// 2=>5 * 2<=5 return 2
// 3=>0
// 4=>0
// 5=>0 
// Expected Output: 2
// Explanation: All papers have 2 citations. Hence, h-index is 2.
// Single Paper:

// Input: [7]
// 0=>0 
// 1=>1 ** 1<=7 return 7

// Expected Output: 1
// Explanation: Only one paper exists, and it has been cited 7 times.
// Large Citations Small h-index:

// Input: [1000, 1000, 1, 1, 1]
// 0=>0 
// 1=>5 
// 2=>2 ** 2<=5
// 3=>2
// 4=>2
// 5=>2 
// Expected Output: 3
// Explanation: Only 3 papers have at least 3 citations.
// Sparse Citations:

// Input: [0, 1000, 0, 0, 5]
// Expected Output: 2
// Explanation: Two papers have at least 2 citations.
// All Above h-index:

// Input: [10, 10, 10, 10, 10, 10]
// Expected Output: 6
// Explanation: All 6 papers have at least 6 citations.
// All Below h-index:

// Input: [4, 4, 4, 4]
// Expected Output: 4
// Explanation: All 4 papers have at least 4 citations.
// Mixed Values:

// Input: [1, 4, 1, 4, 5, 6, 7, 8]
// Expected Output: 5
// Explanation: 5 papers have at least 5 citations each.