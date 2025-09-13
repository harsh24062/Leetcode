class Solution {
    public int maxFreqSum(String s) {
        int maxVowelFreq=0;
        int maxConsFreq=0;
        int freq[]=new int[26];

        for(char ch:s.toCharArray()){
           if(ch=='a' || ch=='i' || ch=='o' || ch=='e' ||ch=='u'){
              freq[ch-'a']++;
              maxVowelFreq=Math.max(maxVowelFreq,freq[ch-'a']);
           }else{
              freq[ch-'a']++;
              maxConsFreq=Math.max(maxConsFreq,freq[ch-'a']);
           }
        }

        return maxVowelFreq + maxConsFreq;
    }
}
