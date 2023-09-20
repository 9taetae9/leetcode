class Solution {
public:
    string intToRoman(int num) {
        vector<string> v;
        string temp;
        int pos=0;
        char c[4]={'I','X','C','M'};
        while(num){
            int n = num%10; pos++;  //일의 자리부터 구하기 시작 일,십,백,천 1,2,3,4
            if(n==4||n==9){
                if(n==4){ 
                    if(pos==1) v.push_back("IV");
                    else if(pos==2) v.push_back("XL");
                    else v.push_back("CD");
                }
                else{  
                    if(pos==1) v.push_back("IX");
                    else if(pos==2) v.push_back("XC");
                    else v.push_back("CM");
                }
            }
            else if(0<=n&&n<=3){
                int i=0;
                
                while(i!=n){
                    temp+=c[pos-1];
                    i++;
                }
                v.push_back(temp);
                temp.clear();
            }
            else{
                int i=0;
                char k[3]={'V','L','D'};
                temp+=k[pos-1];
                while(i!=n-5){
                    temp+=c[pos-1];
                    i++;
                }
                v.push_back(temp);
                temp.clear();
            }
            num/=10; 
        }
        reverse(v.begin(), v.end());
        for(auto e:v)
        temp+=e;
        return temp;
    }
};
