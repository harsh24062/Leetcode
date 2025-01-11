//my approach

class Solution {
    public boolean canConstruct(String s, int k) {

        int n=s.length();
        
        //edge cases
        if(n==k)return true;
        if(k>n)return false;


        int freq[]=new int[26];
        for(char i:s.toCharArray()){
            freq[i-'a']++;
        }

        int odd=0;
        for(int i:freq){
         if(i%2!=0)odd++;
        }

        if(odd<=k) return true;
        return false;
    }
}
