// first approach using three arrays

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
       // three array approach
       
       //left array
       int left[]=new int[n];  // will count no. of operation from left
       //right array
       int right[]=new int[n]; // will count no. of operation from right

      int oneInLeft=boxes.charAt(0)-'0';
       for(int i=1;i<n;i++){
         left[i]= left[i-1] + oneInLeft;
         oneInLeft+=boxes.charAt(i)-'0';
       }

      int oneInRight=boxes.charAt(n-1) - '0';
      for(int i=n-2;i>=0;i--){
        right[i]= right[i+1] + oneInRight;
        oneInRight+=boxes.charAt(i)-'0';
      } 

      int result[]=new int[n];
      for(int i=0;i<n;i++){
        result[i]=left[i]+right[i];
      }
      return result;
    }
}

//second approach using only one array 

class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
       // one array approach
       
       //left array
       int result[]=new int[n];  // will count no. of operation from left and then from right
      

      int oneInLeft=boxes.charAt(0)-'0';
       for(int i=1;i<n;i++){
         result[i]= result[i-1] + oneInLeft;
         oneInLeft+=boxes.charAt(i)-'0';
       }

      int previous=0;
      int oneInRight=boxes.charAt(n-1) - '0';
      for(int i=n-2;i>=0;i--){
       previous=previous + oneInRight;
       result[i]+=previous;
       oneInRight+=boxes.charAt(i)-'0';
      } 

      return result;
    }
}






