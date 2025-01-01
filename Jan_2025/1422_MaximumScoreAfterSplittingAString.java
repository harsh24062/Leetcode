// first approach  TC-O(2n), SC-O(1)
class Solution {
    public int maxScore(String s) {

        int ones=0;
        for(char i:s.toCharArray()){
            if(i=='1')ones++;
        }

        int zeros=0;
        int score=0;
        for(int i=0;i<s.length()-1;i++){
            char ch=s.charAt(i);
            if(ch=='1') ones--;
            else zeros++;
            score=Math.max(score,zeros+ones);
        }
        return score;
    }
}

// second approach (optimized)  TC-O(n), SC-O(1)

// score = ZeroInLeft + OneInRight
        // OneInRight = totalOne - OneInLeft;
        // score = zeroInLeft + totalOne - OneInLeft;
        // totalOne is constant
        // so for Max score maximize -> zeroInLeft - OneInLeft

class Solution {
    public int maxScore(String s) {
      
      int zeros=0;
      int ones=0;
      int max=-1; // max of zeroInLeft - OneInLeft
      for(int i=0;i<s.length()-1;i++){
         char ch=s.charAt(i);

         if(ch=='1')ones++;
         else zeros++;
         max=Math.max(max,zeros-ones);
      }
      if(s.charAt(s.length()-1)=='1')ones++;
     return max+ones;
    }
}





