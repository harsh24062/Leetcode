class Solution {
    long func(String word, int k){
        int a=0,e=0,i=0,o=0,u=0;
        int cons=0;
        int left=0,right=0;
        long count=0;
      
      while(right<=word.length()){

      if(a>0 && e>0 && i>0 && o>0 && u>0 && cons>=k){
            count+=word.length()-right+1;
        
        if(word.charAt(left)=='a')a--;
        else if(word.charAt(left)=='e')e--;
        else if(word.charAt(left)=='i')i--;
        else if(word.charAt(left)=='o')o--;
        else if(word.charAt(left)=='u')u--;
        else cons--;
        left++;
            
        }




       else{
        if(right==word.length())break;
        if(word.charAt(right)=='a')a++;
        else if(word.charAt(right)=='e')e++;
        else if(word.charAt(right)=='i')i++;
        else if(word.charAt(right)=='o')o++;
        else if(word.charAt(right)=='u')u++;
        else cons++;

        right++;
       }
      }

        return count;
    }
    public long countOfSubstrings(String word, int k) {
       return func(word,k) - func(word,k+1);
    }
}
