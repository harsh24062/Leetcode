class Solution {

     boolean isPrefixAndSuffix(String str1, String str2){

        if(str1.length()>str2.length())return false;

        boolean prefix=str2.startsWith(str1);
        //prefix

       boolean suffix=str2.endsWith(str1);

        return prefix && suffix;
     }

    public int countPrefixSuffixPairs(String[] words) {
        int count=0;

      for(int i=0;i<words.length;i++){
        String str1=words[i];
        for(int j=i+1;j<words.length;j++){
        String str2=words[j];
         if(isPrefixAndSuffix(str1,str2)) count++;
        }
      }

        return count;
    }
}





