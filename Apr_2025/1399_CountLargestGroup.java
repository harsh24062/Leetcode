class Solution {

    int sum(String num){
        int sum=0;
        for(char i:num.toCharArray()){
         sum+=i-'0';
        }
      return sum;
    }

    public int countLargestGroup(int n) {
        int pairs[] = new int[37];
        int maxSize=0;
        int number=0;
        
        for(int i=1;i<=n;i++){
          int sum = sum(Integer.toString(i));
          pairs[sum]++;
          if(pairs[sum]>maxSize){
            number=1;
            maxSize=pairs[sum];
          }
          else if(pairs[sum]==maxSize)number++;
        }

        return number;
    }
}
