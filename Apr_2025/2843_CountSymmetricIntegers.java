class Solution {

    boolean isSymmetric(String num){
      if(num.length()%2!=0)return false;

      int n=num.length()/2;
      int leftSum=0,rightSum=0;

      for(int i=0;i<n;i++){
        leftSum+=num.charAt(i)-'0';
        rightSum+=num.charAt(n+i)-'0';
      }

      return leftSum==rightSum;
    }

    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
           if(isSymmetric(Integer.toString(i)))ans++;
        }
        return ans;
    }
}


// optimal
class Solution {

    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        // answer will be of 2digit or 4 digit (10000 is max. range)
        for(int i=low;i<=high;i++){
          if((i>=10 && i<=99) && i%11==0){
            ans++;
          }else if(i>=1000 && i<=9999){
            int firstDigit=i/1000;
            int secondDigit=(i/100)%10;
            int thirdDigit=(i/10)%10;
            int fourthDigit=i%10;

            if((firstDigit + secondDigit)==(thirdDigit + fourthDigit))ans++;
          }
        }
        return ans;
    }
}
