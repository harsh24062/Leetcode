class Solution {
    public String largestGoodInteger(String num) {
        
        String ans="";
        int n=-1;

        for(int i=0;i<=num.length()-3;i++){
          if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2) && num.charAt(i)-'0'>n){
            ans=num.substring(i,i+3);
            n=num.charAt(i)-'0';
          }
        }
        return ans;
    }
}
