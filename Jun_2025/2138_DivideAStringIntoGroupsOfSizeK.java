class Solution {
    public String[] divideString(String s, int k, char fill) {
        while(s.length()%k!=0){
            s=s+fill;
        }

        String result[]=new String[s.length()/k];
        
        int index=0;
        for(int i=0;i<s.length();i+=k){
            result[index]=s.substring(i,i+k);
            index++;
        }

        return result;
    }
}
