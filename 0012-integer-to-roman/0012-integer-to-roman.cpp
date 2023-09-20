class Solution {
public:
    string intToRoman(int num) {
        vector<string> v;
        string temp;
        int pos=0;
        int i=0;
        char c[4]={'I','X','C','M'};
        char k[3]={'V','L','D'};
        while(num){
            int n = num%10; pos++;  //일의 자리부터 구하기 시작 일,십,백,천 1,2,3,4
            if(n==4||n==9){
                temp+=c[pos-1];
                if(n==4)
                    temp+=k[pos-1];
                else 
                    temp+=c[pos];

                v.push_back(temp);
                temp.clear();
            }
            else if(0<=n&&n<=3){
                while(i!=n){
                    temp+=c[pos-1];
                    i++;
                }
                v.push_back(temp);
                temp.clear();
                i=0;
            }
            else{
                temp+=k[pos-1];
                while(i!=n-5){
                    temp+=c[pos-1];
                    i++;
                }
                v.push_back(temp);
                temp.clear();
                i=0;
            }
            num/=10; 
        }

        reverse(v.begin(), v.end());
        for(auto e:v)
        temp+=e;
        return temp;
    }
};
