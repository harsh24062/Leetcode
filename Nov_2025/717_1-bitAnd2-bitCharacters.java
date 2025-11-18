class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       int ones = 0;
       int i=0;
       int n = bits.length;

       while(i<n-1){
         if(bits[i]==1){
            if(ones==0)ones++;
            else ones--;
         }else{
            if(ones>0)ones--;
         }
         i++;
       }
       
       return ones>0?false:true;
    }
}
