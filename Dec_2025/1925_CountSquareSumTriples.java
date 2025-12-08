class Solution {
    public int countTriples(int n) {
        int count = 0;
        
        for(int i=1;i<=n;i++){
          for(int j=1;j<=n;j++){
            for(int z=1;z<=n;z++){
                if(i*i + j*j == z*z)count++;
            }
          }
        }

        return count;
    }
}

// better
class Solution {
    public int countTriples(int n) {
        int count = 0;
        
        for(int i=1;i<=n;i++){
          for(int j=i+1;j<=n;j++){
            int sum = i*i + j*j;
            int sqrt = (int)Math.sqrt(sum);
            if(sqrt*sqrt==sum && sqrt<=n)count+=2;
          }
        }

        return count;
    }
}
