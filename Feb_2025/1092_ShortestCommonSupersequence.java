class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();
        int dp[][]=new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                 dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        StringBuilder subseq=new StringBuilder();
        int i=n1,j=n2;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                subseq.append(str1.charAt(i-1));
                i--;j--;
            }
            else{
                if(dp[i-1][j]>=dp[i][j-1]) i--;
                else j--;
            }
        }
        subseq.reverse();  //this is common longest subsequence

      StringBuilder result=new StringBuilder();
        i=0;
        j=0;  // i->str1 j->str2
        int subseqIndex=0;
        while(subseqIndex<subseq.length()){
               if(str1.charAt(i)!=subseq.charAt(subseqIndex)){
                    result.append(str1.charAt(i)); 
                    i++;
               }
               if(str2.charAt(j)!=subseq.charAt(subseqIndex)){
                 result.append(str2.charAt(j)); 
                    j++;
               }
            if(str1.charAt(i)==subseq.charAt(subseqIndex) && str2.charAt(j)==subseq.charAt(subseqIndex)){
                      result.append(subseq.charAt(subseqIndex)); 
                      subseqIndex++;    
                      i++;
                      j++;
               }
        } 

        while(i<str1.length()){
            result.append(str1.charAt(i)); 
                    i++;
        }
         while(j<str2.length()){
            result.append(str2.charAt(j)); 
                    j++;
        }
       
  return result.toString();

    }
}
