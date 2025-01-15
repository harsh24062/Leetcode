class Solution {
 //   https://www.youtube.com/watch?v=9wrKWB1xDoY

     boolean isSet(int x,int bit){
         int ans= x & (1<<bit);

         return (ans>0)?true:false;
     }

     int setBit(int x, int bit){
        int ans= x | (1<<bit);
        return ans;
     }

      int unSetBit(int x, int bit){
        int ans= x & ~(1<<bit);
        return ans;
     }


    public int minimizeXor(int num1, int num2) {
      
     int x=num1;   //agar x == num1 hoga toh xor sabsai kaam ayega

        int curBits=Integer.bitCount(x);
        int setBits2=Integer.bitCount(num2);

        if(curBits<setBits2){   // answer mai kaam bits h, so we have too add 1 bits in left so that answer kaam ayai
          int bit=0;
          while(curBits<setBits2){
            if(!isSet(x,bit)){
              x=   setBit(x,bit);
                curBits++;
            }
            bit++;
          }
        }

        else if(curBits>setBits2){  // answer mai jada bits h, so we have too delete 1 bits in left , kyoki XOR with num1 m right wali bit match ho kar nullify ho jayai
           int bit=0;
           while(curBits>setBits2){
              if(isSet(x,bit)){
               x= unSetBit(x,bit);
                setBits2++;
              }
              bit++;
           }
        }

         return x;
    }
}


// second approach
class Solution {
   // https://www.youtube.com/watch?v=9wrKWB1xDoY

   boolean isSet(int num,int bit){
     int ans = num & (1<<bit);
     return (ans>0)?true:false;
   }

   int setBit(int num, int bit){
    int ans= num | (1<<bit);
    return ans; 
   }

    public int minimizeXor(int num1, int num2) {

      int x=0;
      int bitRequire=Integer.bitCount(num2); 

     for(int i=31;i>=0 && bitRequire>0;i--){

         if(isSet(num1,i)){
           x= setBit(x,i);
           bitRequire--;
         }

     }
      int bit=0;
     while(bitRequire>0){

       if(!isSet(x,bit)){
        x= setBit(x,bit);
         bitRequire--;
       }
       bit++;
     }

     return x;

    }
}


