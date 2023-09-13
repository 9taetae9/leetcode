class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;
        generate("", 0, 0, n, result); 
        return result;
    }
    void generate(string current, int opencnt, int closecnt, int n, vector<string>& result){
        
        if(current.size()==2*n){
            result.push_back(current);
            return ;
        }

        if(opencnt<n){
            generate(current+"(",opencnt+1, closecnt, n, result);
        }
        if(closecnt<opencnt){
            generate(current+")",opencnt, closecnt+1, n, result);
        }
    }
};
// The difference between vector<string> result and vector<string>& result is in how they are declared and used, particularly in the context of function parameters:

// vector<string> result:

// When you see this in a function parameter, it means the function accepts a vector<string> by value. This means when you pass a vector to this function, a copy of that vector is created and used inside the function. Any modifications you make to result inside the function will not affect the original vector you passed to the function.
// This can be inefficient if the vector is large, since a full copy of the vector is made.
// vector<string>& result:

// When you see this in a function parameter, it means the function accepts a vector<string> by reference. This means when you pass a vector to this function, no new copy is made. Instead, the function works directly on the original vector. Any modifications you make to result inside the function will be reflected in the original vector you passed to the function.
// This is efficient since no copy is made, especially useful when working with large vectors or when you want to modify the original vector.