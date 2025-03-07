class Solution {

    boolean isPrime(int num){
        if(num<2)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }

    public int[] closestPrimes(int left, int right) {
     
     int prime1=-1;
     int prime2=-1;

     int curPrime1=-1;
     int curPrime2=-1;

     int diff=Integer.MAX_VALUE;

      for(int i=left;i<=right;i++){
        if(isPrime(i)){
            if(prime1==-1){prime1=i; curPrime1=i;}
            else if(prime2==-1){prime2=i; curPrime2=i;
            diff=curPrime2-curPrime1;
            }
            else{
               curPrime1=curPrime2;
               curPrime2=i;
               if(curPrime2-curPrime1<diff){
                diff=curPrime2-curPrime1;
                prime1=curPrime1;
                prime2=curPrime2;
               }
            }
        }   
      }

      if(prime2==-1)return new int[]{-1,-1};
       return new int[]{prime1,prime2};
    }
}
