class Solution {
public:
    string convert(string s, int numRows) {
        if(s.length()==1||numRows==1) return s;
        
        vector<string> rows(numRows);
        bool goingdown = false;
        int curr=0;
        

        for(auto c : s)
        {
            rows[curr]+=c;
            if(curr==0 || curr==numRows-1)
                goingdown=!goingdown;
            curr+= goingdown ? 1:-1 ;
        }
        string ret;
        for(auto row : rows){
            ret+=row;
        }
        return ret;
    }
};

        