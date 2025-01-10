// my approach
// 81.40% faster


class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int maxFreq2[]=new int[26]; //it will store the maximum freq. of character from strings in words2[]

        for(String word:words2){
            int freq[]=new int[26];

            for(char ch:word.toCharArray()){
                freq[ch-'a']++;
            }
            
            for(int i=0;i<26;i++){
                maxFreq2[i]=Math.max(maxFreq2[i],freq[i]);
            }
        }

        List<String> ans=new ArrayList<>();

        for(String word:words1){
            int freq[]=new int[26];

            for(char ch:word.toCharArray()){
                freq[ch-'a']++;
            }

            boolean flag=true;

            for(int i=0;i<26;i++){
              if(freq[i]<maxFreq2[i]){
                flag=false;
                break;
              }
            } 

            if(flag) ans.add(word);
        }

        return ans;
    }
}
