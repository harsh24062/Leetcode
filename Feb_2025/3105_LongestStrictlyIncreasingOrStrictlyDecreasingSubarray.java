// brute force

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // checking stric. increasing
        int count1=0;
        for(int i=0;i<nums.length;i++){
            int max=1;
            for(int j=i+1;j<nums.length;j++){
               if(nums[j]>nums[j-1]) max++;
               else break;
            }
            count1=Math.max(count1,max);
        }
       
       //checking stric. decreasing
       int count2=0;
         for(int i=0;i<nums.length;i++){
            int min=1;
            for(int j=i+1;j<nums.length;j++){
               if(nums[j]<nums[j-1]) min++;
               else break;
            }
            count2=Math.max(count2,min);
        }
        
        return Math.max(count1,count2);
    }
}


// better solution
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        // stricty increasing
        int count1=1;
        int prevMax=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]>nums[i-1]) prevMax++;
           else{prevMax=1;}
           count1=Math.max(count1,prevMax); 
        }

         // stricty decreasing
        int count2=1;
        int prevMin=1;
        for(int i=1;i<nums.length;i++){
           if(nums[i]<nums[i-1]) prevMin++;
           else{prevMin=1;}
           count2=Math.max(count2,prevMin); 
        }

        return Math.max(count1,count2);
    }
}


