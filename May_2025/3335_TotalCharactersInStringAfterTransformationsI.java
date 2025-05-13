class Solution {
    int mod = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        int freq[] = new int[26];

        for(char i:s.toCharArray()){
            freq[i-'a']++;
        }

        for(int i=1;i<=t;i++){
           int temp[] = new int[26];
          
          for(int j=0;j<26;j++){
            char ch = (char)('a' + j);

            if(freq[j]%mod>0){
                if(ch=='z'){
                  temp[0]= (temp[0]+freq[j])%mod;
                  temp[1]= (temp[1]+freq[j])%mod;
                }else{
                   temp[ch-'a'+1] = (freq[j]+temp[ch-'a'+1])%mod;
                }
            }
          }
          freq=temp;
        }

        int ans=0;
        for(int i:freq){
            ans = (ans+i)%mod;
        }
        return ans;
    }
}
