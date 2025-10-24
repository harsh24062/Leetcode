class Solution {
    boolean isBalance(int num){
      int freq[] = new int[10];

      while(num>0){
        if(num%10==0)return false;
        freq[num%10]++;
        num/=10;
      }
      
      for(int i=1;i<10;i++){
        if(freq[i]!=0 && i!=freq[i])return false;
      }

      return true;
    }
    public int nextBeautifulNumber(int n) {
    
        while(n<Integer.MAX_VALUE){
          n++;
          if(isBalance(n))return n;        
        }
        return 0;
    }
}
