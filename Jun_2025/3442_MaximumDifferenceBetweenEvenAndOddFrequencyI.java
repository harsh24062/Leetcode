class Solution {
    public int maxDifference(String s) {
        int freq[] = new int[26];

        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        int maxOddFreq=0;
        int minEvenFreq=Integer.MAX_VALUE;

        for(int i=0;i<26;i++){
           if(freq[i]%2!=0){
             maxOddFreq=Math.max(maxOddFreq,freq[i]);
           }else if(freq[i]>0){
              minEvenFreq=Math.min(minEvenFreq,freq[i]);
           }
        }
           
        return maxOddFreq-minEvenFreq;
    }
}
